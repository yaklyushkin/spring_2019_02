package yaklyushkin_otus.spring_2019_02.hw05_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import yaklyushkin_otus.spring_2019_02.hw05.builders.AuthorBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.builders.GenreBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.service.AuthorService;
import yaklyushkin_otus.spring_2019_02.hw05.service.GenreService;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;
import yaklyushkin_otus.spring_2019_02.hw05_app.config.Props;

public class Hw05Application {

    public static void main(String[] args) throws WrongDataException {
        ApplicationContext ctx = SpringApplication.run(Hw05Configuration.class, args);


    }
}
