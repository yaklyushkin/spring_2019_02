package yaklyushkin_otus.spring_2019_02.hw05.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;

import yaklyushkin_otus.spring_2019_02.hw05.Consts;

import org.junit.jupiter.api.Test;

public class GenreTest {

    @Test
    public void genreDirectCreationTest() {
        assertEquals(Consts.GENRE_ID_OK_1, Consts.GENRE_OK_1.getGenreId());
        assertEquals(Consts.GENRE_ID_OK_2, Consts.GENRE_OK_2.getGenreId());
        assertEquals(Consts.GENRE_ID_OK_3, Consts.GENRE_OK_3.getGenreId());
        assertEquals(Consts.GENRE_ID_ERROR_2, Consts.GENRE_ERROR_2.getGenreId());
        assertEquals(Consts.GENRE_NAME_OK_1, Consts.GENRE_OK_1.getGenreName());
        assertEquals(Consts.GENRE_NAME_OK_2, Consts.GENRE_OK_2.getGenreName());
        assertEquals(Consts.GENRE_NAME_ERROR_1, Consts.GENRE_OK_3.getGenreName());
        assertEquals(Consts.GENRE_NAME_ERROR_2, Consts.GENRE_ERROR_2.getGenreName());
    }

    @Test
    public void genreBuildOKTest() throws WrongDataException {
        Genre genre = Consts.GENRE_BUILDER.build(Consts.GENRE_ID_OK_1, Consts.GENRE_NAME_OK_1);
        assertEquals(Consts.GENRE_ID_OK_1, genre.getGenreId());
        assertEquals(Consts.GENRE_NAME_OK_1, genre.getGenreName());

        genre = Consts.GENRE_BUILDER.build(Consts.GENRE_ID_OK_2, Consts.GENRE_NAME_OK_2);
        assertEquals(Consts.GENRE_ID_OK_2, genre.getGenreId());
        assertEquals(Consts.GENRE_NAME_OK_2, genre.getGenreName());

        genre = Consts.GENRE_BUILDER.build(Consts.GENRE_ID_OK_3, Consts.GENRE_NAME_OK_1);
        assertEquals(Consts.GENRE_ID_OK_3, genre.getGenreId());
        assertEquals(Consts.GENRE_NAME_OK_1, genre.getGenreName());
    }

    @Test
    public void genreBuildWrongIdTest() throws WrongDataException {
        WrongDataException exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.GENRE_BUILDER.build(
                                Consts.GENRE_ID_ERROR_2,
                                Consts.GENRE_NAME_OK_1),
                        "nothing");
        assertEquals("Ошибка в данных: genreId='-10'", exception.getMessage());
    }

    @Test
    public void genreBuildWrongNameTest() throws WrongDataException {
        WrongDataException exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.GENRE_BUILDER.build(
                                Consts.GENRE_ID_OK_1,
                                Consts.GENRE_NAME_ERROR_1),
                        "nothing");
        assertEquals("Ошибка в данных: genreName='<null>'", exception.getMessage());

        exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.GENRE_BUILDER.build(
                                Consts.GENRE_ID_OK_1,
                                Consts.GENRE_NAME_ERROR_2),
                        "nothing");
        assertEquals("Ошибка в данных: genreName=' '", exception.getMessage());
    }
}
