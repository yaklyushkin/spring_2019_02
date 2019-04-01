package yaklyushkin_otus.spring_2019_02.hw05.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;

import yaklyushkin_otus.spring_2019_02.hw05.Consts;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;


public class BookTest {

    @Test
    public void genreDirectCreationTest() {
        assertEquals(Consts.BOOK_ID_OK_1, Consts.BOOK_OK_1.getBookId());
        assertEquals(Consts.BOOK_ID_OK_2, Consts.BOOK_OK_2.getBookId());
        assertEquals(Consts.BOOK_ID_OK_3, Consts.BOOK_OK_3.getBookId());
        assertEquals(Consts.BOOK_ID_ERROR_1, Consts.BOOK_ERROR_1.getBookId());
        assertEquals(Consts.BOOK_TITLE_OK_1, Consts.BOOK_OK_1.getTitle());
        assertEquals(Consts.BOOK_TITLE_OK_2, Consts.BOOK_OK_2.getTitle());
        assertEquals(Consts.BOOK_TITLE_ERROR_1, Consts.BOOK_ERROR_2.getTitle());
        assertEquals(Consts.BOOK_TITLE_ERROR_2, Consts.BOOK_ERROR_3.getTitle());
        assertTrue(compareAuthors(Consts.BOOK_AUTHORS, Consts.BOOK_OK_2));
        assertTrue(compareAuthors(Consts.BOOK_AUTHORS, Consts.BOOK_ERROR_1));
        assertTrue(compareAuthors(Consts.BOOK_AUTHORS, Consts.BOOK_ERROR_2));
        assertTrue(compareAuthors(Consts.BOOK_AUTHORS, Consts.BOOK_ERROR_3));
        assertTrue(compareGenres(Consts.BOOK_GENRES, Consts.BOOK_OK_2));
        assertTrue(compareGenres(Consts.BOOK_GENRES, Consts.BOOK_ERROR_1));
        assertTrue(compareGenres(Consts.BOOK_GENRES, Consts.BOOK_ERROR_2));
        assertTrue(compareGenres(Consts.BOOK_GENRES, Consts.BOOK_ERROR_3));
        assertFalse(compareAuthors(Consts.BOOK_AUTHORS, Consts.BOOK_OK_1));
        assertFalse(compareGenres(Consts.BOOK_GENRES, Consts.BOOK_OK_1));
        assertTrue(compareAuthors(Collections.emptyList(), Consts.BOOK_OK_1));
        assertFalse(compareAuthors(Consts.BOOK_AUTHORS, Consts.BOOK_OK_1));
        assertTrue(compareGenres(Collections.emptyList(), Consts.BOOK_OK_1));
        assertFalse(compareGenres(Consts.BOOK_GENRES, Consts.BOOK_OK_1));
    }

    @Test
    public void genreBuildOKTest() throws WrongDataException {
        Book book = Consts.BOOK_BUILDER.build(
                Consts.BOOK_ID_OK_1, Consts.BOOK_TITLE_OK_1, Collections.emptyList(), Collections.emptyList());
        assertEquals(Consts.BOOK_ID_OK_1, book.getBookId());
        assertEquals(Consts.BOOK_TITLE_OK_1, book.getTitle());
        assertTrue(compareAuthors(Collections.emptyList(), book));
        assertTrue(compareGenres(Collections.emptyList(), book));

        book = Consts.BOOK_BUILDER.build(
                Consts.BOOK_ID_OK_2, Consts.BOOK_TITLE_OK_2, Collections.emptyList(), Collections.emptyList());
        assertEquals(Consts.BOOK_ID_OK_2, book.getBookId());
        assertEquals(Consts.BOOK_TITLE_OK_2_CHECK, book.getTitle());
        assertTrue(compareAuthors(Collections.emptyList(), book));
        assertTrue(compareGenres(Collections.emptyList(), book));

        book = Consts.BOOK_BUILDER.build(
                Consts.BOOK_ID_OK_3, Consts.BOOK_TITLE_OK_2, Consts.BOOK_AUTHORS, Consts.BOOK_GENRES);
        assertEquals(Consts.BOOK_ID_OK_3, book.getBookId());
        assertEquals(Consts.BOOK_TITLE_OK_2_CHECK, book.getTitle());
        assertTrue(compareAuthors(Consts.BOOK_AUTHORS, book));
        assertTrue(compareGenres(Consts.BOOK_GENRES, book));

    }

    @Test
    public void bookBuildWrongIdTest() throws WrongDataException {
        WrongDataException exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.BOOK_BUILDER.build(
                                Consts.BOOK_ID_ERROR_1, Consts.BOOK_TITLE_OK_1,
                                Collections.emptyList(), Collections.emptyList()),
                        "nothing");
        assertEquals("Ошибка в данных: bookId='-10'", exception.getMessage());
    }

    @Test
    public void bookBuildWrongNameTest() throws WrongDataException {
        WrongDataException exception = assertThrows(
                WrongDataException.class,
                () -> Consts.BOOK_BUILDER.build(
                        Consts.BOOK_ID_OK_1, Consts.BOOK_TITLE_ERROR_1,
                        Collections.emptyList(), Collections.emptyList()),
                "nothing");
        assertEquals("Ошибка в данных: bookTitle='<null>'", exception.getMessage());

        exception = assertThrows(
                WrongDataException.class,
                () -> Consts.BOOK_BUILDER.build(
                        Consts.BOOK_ID_OK_1, Consts.BOOK_TITLE_ERROR_2,
                        Collections.emptyList(), Collections.emptyList()),
                "nothing");
        assertEquals("Ошибка в данных: bookTitle=' '", exception.getMessage());
    }

    private static boolean compareAuthors(List<Author> expected, Book actual) {
        if (expected.size() != actual.getAuthors().size()) {
            return false;
        }
        for (int index = 0; index < expected.size(); ++index) {
            if (!expected.get(index).equals(actual.getAuthors().get(index))) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareGenres(List<Genre> expected, Book actual) {
        if (expected.size() != actual.getGenres().size()) {
            return false;
        }
        for (int index = 0; index < expected.size(); ++index) {
            if (!expected.get(index).equals(actual.getGenres().get(index))) {
                return false;
            }
        }
        return true;
    }
}
