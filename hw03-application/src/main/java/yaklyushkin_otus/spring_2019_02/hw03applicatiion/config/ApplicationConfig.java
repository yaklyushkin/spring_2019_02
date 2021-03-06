package yaklyushkin_otus.spring_2019_02.hw03applicatiion.config;

import yaklyushkin.spring_2019_02.hw03.consts.Consts;
import yaklyushkin.spring_2019_02.hw03.dao.QuestionsDAO;
import yaklyushkin.spring_2019_02.hw03.dao.impl.CSVQuestionsReader;
import yaklyushkin.spring_2019_02.hw03.exceptions.WrongDataException;
import yaklyushkin.spring_2019_02.hw03.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class ApplicationConfig {
    @Bean("csvQuestionsReader")
    public QuestionsDAO questionsDAO(
            @Autowired MessageService messageSource,
            YamlProps props) throws IOException, WrongDataException {
        logger.info(String.format(
                "Hw03Application: make QuestionsDAO with language='%s', filePath='%s', questionsCount=%d",
                props.getLanguage(), props.getFilePath(), props.getQuestionsCount()));
        if (!props.getLanguage().equals(Consts.LANGUAGE_RUSSIAN) &&
                !props.getLanguage().equals(Consts.LANGUAGE_ENGLISH)) {
            throw new WrongDataException(String.format("Не задан язык приложения: '%s'!", props.getLanguage()));
        }

        String fileName = props.getFilePath();
        String csvFileName = String.format(fileName, props.getLanguage());
        ClassPathResource resourceCSVFile = new ClassPathResource(csvFileName);
        String filePath = resourceCSVFile.getFile().getAbsolutePath();

        int questionsCount =
                props.getQuestionsCount() == 0 ? 5 : props.getQuestionsCount();

        return new CSVQuestionsReader(filePath, props.getLanguage(), questionsCount, messageSource);
    }

    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
}
