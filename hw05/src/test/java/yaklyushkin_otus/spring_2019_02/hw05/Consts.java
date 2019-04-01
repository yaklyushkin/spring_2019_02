package yaklyushkin_otus.spring_2019_02.hw05;

import yaklyushkin_otus.spring_2019_02.hw05.builders.AuthorBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.builders.BookBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.builders.GenreBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.consts.StringConsts;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;

import yaklyushkin_otus.spring_2019_02.hw05.mocks.MessageServiceMock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consts {

    public static MessageService MESSAGE_SERVICE = new MessageServiceMock();

    public static GenreBuilder GENRE_BUILDER =
            new GenreBuilder(StringConsts.LANGUAGE_RUSSIAN, MESSAGE_SERVICE);

    public static AuthorBuilder AUTHOR_BUILDER =
            new AuthorBuilder(StringConsts.LANGUAGE_RUSSIAN, MESSAGE_SERVICE);

    public static BookBuilder BOOK_BUILDER =
            new BookBuilder(StringConsts.LANGUAGE_RUSSIAN, MESSAGE_SERVICE);

    public static int GENRE_ID_OK_1 = 1;
    public static int GENRE_ID_OK_2 = 20;
    public static int GENRE_ID_OK_3 = 0;
    public static int GENRE_ID_ERROR_2 = -10;
    public static String GENRE_NAME_OK_1 = "child";
    public static String GENRE_NAME_OK_2 = "name another";
    public static String GENRE_NAME_ERROR_1 = null;
    public static String GENRE_NAME_ERROR_2 = " ";
    public static Genre GENRE_OK_1 = new Genre(GENRE_ID_OK_1, GENRE_NAME_OK_1);
    public static Genre GENRE_OK_2 = new Genre(GENRE_ID_OK_2, GENRE_NAME_OK_2);
    public static Genre GENRE_OK_3 = new Genre(GENRE_ID_OK_3, GENRE_NAME_ERROR_1);
    public static Genre GENRE_ERROR_2 = new Genre(GENRE_ID_ERROR_2, GENRE_NAME_ERROR_2);

    public static int AUTHOR_ID_OK_1 = 1;
    public static int AUTHOR_ID_OK_2 = 20;
    public static int AUTHOR_ID_OK_3 = 0;
    public static int AUTHOR_ID_ERROR_2 = -10;
    public static String AUTHOR_SURNAME_OK_1 = "Klyushkin";
    public static String AUTHOR_SURNAME_OK_2 = " surname  another";
    public static String AUTHOR_SURNAME_OK_2_CHECK = "Surname Another";
    public static String AUTHOR_SURNAME_OK_3 = null;
    public static String AUTHOR_SURNAME_ERROR_1 = " ";
    public static String AUTHOR_NAME_OK_1 = "Yuriy";
    public static String AUTHOR_NAME_OK_2 = " name  another";
    public static String AUTHOR_NAME_OK_2_CHECK = "Name Another";
    public static String AUTHOR_NAME_ERROR_1 = null;
    public static String AUTHOR_NAME_ERROR_2 = " ";
    public static String AUTHOR_PATRONYMIC_OK_1 = "Alexandrovich";
    public static String AUTHOR_PATRONYMIC_OK_2 = " patronymic  another";
    public static String AUTHOR_PATRONYMIC_OK_2_CHECK = "Patronymic Another";
    public static String AUTHOR_PATRONYMIC_OK_3 = null;
    public static String AUTHOR_PATRONYMIC_ERROR_1 = " ";
    public static Author AUTHOR_OK_1 = new Author(
            AUTHOR_ID_OK_1, AUTHOR_SURNAME_OK_1, AUTHOR_NAME_OK_1, AUTHOR_PATRONYMIC_OK_1);
    public static Author AUTHOR_OK_2 = new Author(
            AUTHOR_ID_OK_2, AUTHOR_SURNAME_OK_2, AUTHOR_NAME_OK_2, AUTHOR_PATRONYMIC_OK_2);
    public static Author AUTHOR_OK_3 = new Author(
            AUTHOR_ID_OK_2, AUTHOR_SURNAME_OK_3, AUTHOR_NAME_OK_2, AUTHOR_PATRONYMIC_OK_3);
    public static Author AUTHOR_OK_4 = new Author(
            AUTHOR_ID_OK_3, AUTHOR_SURNAME_OK_1, AUTHOR_NAME_OK_1, AUTHOR_PATRONYMIC_OK_1);
    public static Author AUTHOR_ERROR_ = new Author(
            AUTHOR_ID_OK_1, AUTHOR_SURNAME_OK_1, AUTHOR_NAME_OK_1, AUTHOR_PATRONYMIC_OK_1);
    public static Author AUTHOR_ERROR_1 = new Author(
            AUTHOR_ID_OK_1, AUTHOR_SURNAME_ERROR_1, AUTHOR_NAME_OK_1, AUTHOR_PATRONYMIC_OK_1);
    public static Author AUTHOR_ERROR_2 = new Author(
            AUTHOR_ID_OK_1, AUTHOR_SURNAME_OK_1, AUTHOR_NAME_ERROR_1, AUTHOR_PATRONYMIC_OK_1);
    public static Author AUTHOR_ERROR_3 = new Author(
            AUTHOR_ID_OK_1, AUTHOR_SURNAME_OK_1, AUTHOR_NAME_ERROR_2, AUTHOR_PATRONYMIC_OK_1);
    public static Author AUTHOR_ERROR_4 = new Author(
            AUTHOR_ID_OK_1, AUTHOR_SURNAME_OK_1, AUTHOR_NAME_OK_1, AUTHOR_PATRONYMIC_ERROR_1);
    public static Author AUTHOR_ERROR_6 = new Author(
            AUTHOR_ID_ERROR_2, AUTHOR_SURNAME_OK_1, AUTHOR_NAME_OK_1, AUTHOR_PATRONYMIC_OK_1);

    public static int BOOK_ID_OK_1 = 1;
    public static int BOOK_ID_OK_2 = 20;
    public static int BOOK_ID_OK_3 = 0;
    public static int BOOK_ID_ERROR_1 = -10;
    public static String BOOK_TITLE_OK_1 = "Book 1";
    public static String BOOK_TITLE_OK_2 = " book  another";
    public static String BOOK_TITLE_OK_2_CHECK = "Book another";
    public static String BOOK_TITLE_ERROR_1 = null;
    public static String BOOK_TITLE_ERROR_2 = " ";
    public static List<Author> BOOK_AUTHORS = new ArrayList<Author>() {{
        add(AUTHOR_OK_1);
    }};
    public static List<Genre> BOOK_GENRES = new ArrayList<Genre>() {{
        add(GENRE_OK_1);
        add(GENRE_OK_2);
    }};
    public static Book BOOK_OK_1 = new Book(
            BOOK_ID_OK_1, BOOK_TITLE_OK_1, Collections.emptyList(), Collections.emptyList());
    public static Book BOOK_OK_2 = new Book(BOOK_ID_OK_2, BOOK_TITLE_OK_2, BOOK_AUTHORS, BOOK_GENRES);
    public static Book BOOK_OK_3 = new Book(
            BOOK_ID_OK_3, BOOK_TITLE_OK_2, Collections.emptyList(), Collections.emptyList());
    public static Book BOOK_ERROR_1 = new Book(BOOK_ID_ERROR_1, BOOK_TITLE_OK_2, BOOK_AUTHORS, BOOK_GENRES);
    public static Book BOOK_ERROR_2 = new Book(BOOK_ID_OK_1, BOOK_TITLE_ERROR_1, BOOK_AUTHORS, BOOK_GENRES);
    public static Book BOOK_ERROR_3 = new Book(BOOK_ID_OK_1, BOOK_TITLE_ERROR_2, BOOK_AUTHORS, BOOK_GENRES);
}
