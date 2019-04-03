package yaklyushkin_otus.spring_2019_02.hw05_app.config;

import yaklyushkin_otus.spring_2019_02.hw05.builders.AuthorBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.builders.GenreBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.dao.AuthorDAO;
import yaklyushkin_otus.spring_2019_02.hw05.dao.GenreDAO;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.service.AuthorService;
import yaklyushkin_otus.spring_2019_02.hw05.service.GenreService;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;
import yaklyushkin_otus.spring_2019_02.hw05.service.impl.AuthorServiceImpl;
import yaklyushkin_otus.spring_2019_02.hw05.service.impl.GenreServiceImpl;
import yaklyushkin_otus.spring_2019_02.hw05_app.service.impl.SpringMessageSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties(Props.class)
public class DAOConfiguration {

    public DAOConfiguration(Props props) {
        logger.info(String.format("DAOConfiguration: init with language='%s'", props.getLanguage()));
        this.props = props;
        this.language = this.props.getLanguage();
    }

    @Bean
    @ConditionalOnMissingBean
    public MessageService messageService() {
        logger.info("AutoConfig: creating MessageService, language:" + this.language);
        return new SpringMessageSource();
    }

    @Bean("authorBuilder")
    @ConditionalOnMissingBean
    public AuthorBuilder authorBuilder(@Autowired MessageService messageService) {
        logger.info("AutoConfig: creating AuthorBuilder");
        return new AuthorBuilder(this.language, messageService);
    }

    @Bean("authorService")
    @ConditionalOnMissingBean
    public AuthorService authorService(@Autowired AuthorDAO authorDAO) {
        logger.info("AutoConfig: creating AuthorServiceImpl");
        return new AuthorServiceImpl(authorDAO);
    }

    @Bean("genreBuilder")
    @ConditionalOnMissingBean
    public GenreBuilder genreBuilder(@Autowired MessageService messageService) {
        logger.info("AutoConfig: creating GenreBuilder");
        return new GenreBuilder(this.language, messageService);
    }

    @Bean("genreService")
    @ConditionalOnMissingBean
    public GenreService genreService(@Autowired GenreDAO genreDAO) {
        logger.info("AutoConfig: creating GenreServiceImpl");
        return new GenreServiceImpl(genreDAO);
    }

    private static final Logger logger = LoggerFactory.getLogger(DAOConfiguration.class);

    private final Props props;

    private final String language;
}
