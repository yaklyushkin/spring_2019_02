package yaklyushkin_otus.spring_2019_02.hw05_app;

import yaklyushkin_otus.spring_2019_02.hw05.builders.AuthorBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.builders.BookBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.builders.GenreBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.service.AuthorService;
import yaklyushkin_otus.spring_2019_02.hw05.service.BookService;
import yaklyushkin_otus.spring_2019_02.hw05.service.GenreService;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Disabled
    @Test
    public void bookDaoTest() throws WrongDataException {
        Application application = new Application();
        ApplicationContext ctx = application.test();

        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService.count());

        BookBuilder bookBuilder = ctx.getBean(BookBuilder.class);
        Book book = bookBuilder.build(0, " My first book ");
        System.out.println(book);
        System.out.println();

        book = bookService.insert(book);
        System.out.println(bookService.count());
        System.out.println();

        AuthorBuilder authorBuilder = ctx.getBean(AuthorBuilder.class);
        Author author1 = authorBuilder.build(1, "klyushkin", " yuriy", "alexandrovich");
        AuthorService authorService = ctx.getBean(AuthorService.class);
        author1 = authorService.insert(author1);

        book = bookService.addAuthorByIds(book.getBookId(), author1.getAuthorId());
        System.out.println(book);
        System.out.println();

        GenreService genreService = ctx.getBean(GenreService.class);
        GenreBuilder genreBuilder = ctx.getBean(GenreBuilder.class);
        Genre genre1 = genreBuilder.build(0, " child");
        genre1 = genreService.insert(genre1);
        Genre genre2 = genreBuilder.build(0, " fiction");
        genre2 = genreService.insert(genre2);

        book = bookService.addGenreByIds(book.getBookId(), genre1.getGenreId());
        System.out.println(book);
        System.out.println();

        System.out.println("create book 2");
        List<Author> authors = new ArrayList<>(1);
        Author author2 = authorBuilder.build(0, "spring", "otus", "2019");
        author2 = authorService.insert(author2);
        authors.add(author2);
        List<Genre> genres = new ArrayList<>(2);
        genres.add(genre1);
        genres.add(genre2);
        book = bookBuilder.build(0, "java 8", authors, genres);
        book = bookService.insert(book);
        System.out.println(book);
        System.out.println();

        System.out.println("remove author 1 from book 2");
        book = bookService.removeAuthor(book, author1);
        System.out.println(book);
        System.out.println();

        System.out.println("remove author 2 from book 2");
        book = bookService.removeAuthor(book, author2);
        System.out.println(book);
        System.out.println();

        System.out.println("remvoe genre 1 from book 2");
        book = bookService.removeGenre(book, genre1);
        System.out.println(book);
        System.out.println();

        System.out.println("update book 2 with initial values");
        book = bookBuilder.build(2, "java 8 new chapter", authors, genres);
        book = bookService.update(book);
        System.out.println(book);
        System.out.println();

        for (Book record : bookService.getAll()) {
            System.out.println(record);
        }
        System.out.println("delete book 2");
        bookService.deleteById(book.getBookId());
        for (Book record : bookService.getAll()) {
            System.out.println(record);
        }
        System.out.println(bookService.count());
        System.out.println();
    }

    private static class Application {

        private ApplicationContext test() {
            return SpringApplication.run(Hw05Configuration.class);
        }
    }
}
