package yaklyushkin_otus.spring_2019_02.hw04application.starter;

import yaklyushkin.spring_2019_02.hw04.consts.Consts;
import yaklyushkin.spring_2019_02.hw04.dao.QuestionsDAO;
import yaklyushkin.spring_2019_02.hw04.dao.impl.CSVQuestionsReader;
import yaklyushkin.spring_2019_02.hw04.exceptions.WrongDataException;
import yaklyushkin.spring_2019_02.hw04.runner.Runner;
import yaklyushkin.spring_2019_02.hw04.runner.impl.DefaultRunner;
import yaklyushkin.spring_2019_02.hw04.service.MessageService;
import yaklyushkin.spring_2019_02.hw04.service.PersonProvider;
import yaklyushkin.spring_2019_02.hw04.service.QuestionsReadService;
import yaklyushkin.spring_2019_02.hw04.service.QuizService;
import yaklyushkin.spring_2019_02.hw04.service.UserInteractionService;
import yaklyushkin.spring_2019_02.hw04.service.impl.ConsolePersonProvider;
import yaklyushkin.spring_2019_02.hw04.service.impl.ConsoleUserInteraction;
import yaklyushkin.spring_2019_02.hw04.service.impl.SimpleQuestionsReadService;
import yaklyushkin.spring_2019_02.hw04.service.impl.SimpleQuizService;
import yaklyushkin_otus.spring_2019_02.hw04application.service.impl.SpringMessageSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ConditionalOnClass(Runner.class)
@EnableConfigurationProperties(Props.class)
public class QuizAutoConfiguration {

    public QuizAutoConfiguration(Props props) {
        logger.info(String.format(
                "QuizAutoConfiguration: init with language='%s', filePath='%s', questionsCount=%d",
                props.getLanguage(), props.getFilePath(), props.getQuestionsCount()));
        this.props = props;
        this.language = this.props.getLanguage() == null ? Consts.LANGUAGE_RUSSIAN : props.getLanguage();
    }

    @Bean
    @ConditionalOnMissingBean
    public MessageService messageService() {
        logger.info("AutoConfig: creating MessageService, default language:" + this.language);
        return new SpringMessageSource();
    }

    @Bean("csvQuestionsReader")
    @ConditionalOnMissingBean
    public QuestionsDAO questionsDAO(@Autowired MessageService messageSource) throws IOException, WrongDataException {
        logger.info("AutoConfig: creating QuestionsDAO");
        if (!this.language.equals(Consts.LANGUAGE_RUSSIAN) &&
            !this.language.equals(Consts.LANGUAGE_ENGLISH)) {
            throw new WrongDataException(String.format("Не задан язык приложения: '%s'!", this.language));
        }

        String fileName =
                this.props.getFilePath() == null ? "data/questions_%s.csv" : this.props.getFilePath();
        String csvFileName = String.format(fileName, this.language);
        ClassPathResource resourceCSVFile = new ClassPathResource(csvFileName);
        String filePath = resourceCSVFile.getFile().getAbsolutePath();

        int questionsCount =
                this.props.getQuestionsCount() == 0 ? 5 : this.props.getQuestionsCount();

        return new CSVQuestionsReader(filePath, this.language, questionsCount, messageSource);
    }

    @Bean("simpleQuestionsReadService")
    @ConditionalOnMissingBean
    public QuestionsReadService questionsReadService (
            @Autowired QuestionsDAO questionsDAO,
            @Autowired MessageService messageSource) throws WrongDataException {
        logger.info("AutoConfig: creating QuestionsReadService");
        return new SimpleQuestionsReadService(
                this.language, messageSource, questionsDAO);
    }

    @Bean("consolePersonProvider")
    @ConditionalOnMissingBean
    public PersonProvider personProvider(@Autowired MessageService messageSource) {
        logger.info("AutoConfig: creating PersonProvider");
        return new ConsolePersonProvider(this.language, messageSource);
    }

    @Bean("consoleUserInteractionService")
    @ConditionalOnMissingBean
    public UserInteractionService userInteractionService() {
        logger.info("AutoConfig: creating UserInteractionService");
        return new ConsoleUserInteraction();
    }

    @Bean("simpleQuizService")
    @ConditionalOnMissingBean
    public QuizService quizService(
            @Autowired MessageService messageSource,
            @Autowired QuestionsReadService questions,
            @Autowired UserInteractionService userInteraction) {
        logger.info("AutoConfig: creating QuizService");
        return new SimpleQuizService(
                this.language,
                messageSource,
                questions,
                userInteraction);
    }

    @Bean("defaultRunner")
    @ConditionalOnMissingBean
    public Runner runner(
            @Autowired MessageService messageSource,
            @Autowired PersonProvider personProvider,
            @Autowired QuizService quiz,
            @Autowired UserInteractionService userInteraction) {
        logger.info("AutoConfig: creating Runner");
        return new DefaultRunner(
                this.language,
                messageSource,
                personProvider,
                quiz,
                userInteraction);
    }

    private static final Logger logger = LoggerFactory.getLogger(QuizAutoConfiguration.class);

    private final Props props;

    private final String language;
}
