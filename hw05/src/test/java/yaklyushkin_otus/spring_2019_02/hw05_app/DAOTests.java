package yaklyushkin_otus.spring_2019_02.hw05_app;

import yaklyushkin_otus.spring_2019_02.hw05.builders.AuthorBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.builders.GenreBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.service.AuthorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import yaklyushkin_otus.spring_2019_02.hw05.service.GenreService;

public class DAOTests {

    @Disabled
    @Test
    public void authorDaoTest() throws WrongDataException {
        Application application = new Application();
        ApplicationContext ctx = application.test();

        AuthorService authorService = ctx.getBean(AuthorService.class);
        System.out.println(authorService.count());

        AuthorBuilder authorBuilder = ctx.getBean(AuthorBuilder.class);
        Author author = authorBuilder.build(0, "klyushkin", " yuriy", "alexandrovich");

        author = authorService.insert(author);
        System.out.println(authorService.count());
        System.out.println(authorService.getById(author.getAuthorId()));

        author = authorBuilder.build(author.getAuthorId(), "klyushkin", " yuriy 22", "alexandrovich");
        authorService.update(author);
        System.out.println(authorService.getById(author.getAuthorId()));

        author = authorBuilder.build(0, "klyushkin", " yuriy 3asas3", "alexandrovich");
        author = authorService.insert(author);
        for (Author record : authorService.getAll()) {
            System.out.println(record);
        }

        authorService.deleteById(author.getAuthorId());
        for (Author record : authorService.getAll()) {
            System.out.println(record);
        }
    }

    @Disabled
    @Test
    public void genreDaoTest() throws WrongDataException {
        Application application = new Application();
        ApplicationContext ctx = application.test();

        GenreService genreService = ctx.getBean(GenreService.class);
        System.out.println(genreService.count());

        GenreBuilder genreBuilder = ctx.getBean(GenreBuilder.class);
        Genre genre = genreBuilder.build(0, " child");

        genre = genreService.insert(genre);
        System.out.println(genreService.count());
        System.out.println(genreService.getById(genre.getGenreId()));
        System.out.println();

        genre = genreBuilder.build(genre.getGenreId(), " another 22");
        genreService.update(genre);
        System.out.println(genreService.getById(genre.getGenreId()));
        System.out.println();

        genre = genreBuilder.build(0, " genre 3asas3");
        genre = genreService.insert(genre);
        for (Genre record : genreService.getAll()) {
            System.out.println(record);
        }
        System.out.println();

        genreService.deleteById(genre.getGenreId());
        for (Genre record : genreService.getAll()) {
            System.out.println(record);
        }
    }

    @SpringBootApplication
    private static class Application {

        private ApplicationContext test() {
            return SpringApplication.run(Hw05Configuration.class);
        }
    }
}
