package yaklyushkin.spring_2019_02.hw01;

import yaklyushkin.spring_2019_02.hw01.consts.Consts;
import yaklyushkin.spring_2019_02.hw01.dao.QuestionsDAO;
import yaklyushkin.spring_2019_02.hw01.dao.impl.CSVQuestionsReader;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan(basePackages = "yaklyushkin.spring_2019_02.hw01")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${common.language}")
    private String language;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/i18n/bundle");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean("csvQuestionsReader")
    public QuestionsDAO questionsDAO(
            @Value("${questions.csvfile.name}") String fileName,
            @Value("${questions.count}") int questionsCount,
            @Autowired
            MessageSource messageSource) throws IOException, WrongDataException {
        if (!language.equals(Consts.LANGUAGE_RUSSIAN) &&
            !language.equals(Consts.LANGUAGE_ENGLISH)) {
            throw new WrongDataException("Не задан язык приложения!");
        }
        String csvFileName = String.format(fileName, this.language);

        ClassPathResource resourceCSVFile = new ClassPathResource(csvFileName);

        String filePath = resourceCSVFile.getFile().getAbsolutePath();
        return new CSVQuestionsReader(filePath, this.language, questionsCount, messageSource);
    }
}
