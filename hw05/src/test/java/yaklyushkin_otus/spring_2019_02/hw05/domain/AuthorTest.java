package yaklyushkin_otus.spring_2019_02.hw05.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import yaklyushkin_otus.spring_2019_02.hw05.Consts;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;

import org.junit.jupiter.api.Test;

public class AuthorTest {

    @Test
    public void authorDirectCreationTest() {
        assertEquals(Consts.AUTHOR_ID_OK_1, Consts.AUTHOR_OK_1.getAuthorId());
        assertEquals(Consts.AUTHOR_ID_OK_2, Consts.AUTHOR_OK_2.getAuthorId());
        assertEquals(Consts.AUTHOR_ID_OK_3, Consts.AUTHOR_OK_4.getAuthorId());
        assertEquals(Consts.AUTHOR_ID_ERROR_2, Consts.AUTHOR_ERROR_6.getAuthorId());

        assertEquals(Consts.AUTHOR_SURNAME_ERROR_1, Consts.AUTHOR_ERROR_1.getAuthorSurname());
        assertEquals(Consts.AUTHOR_SURNAME_OK_1, Consts.AUTHOR_OK_1.getAuthorSurname());
        assertEquals(Consts.AUTHOR_SURNAME_OK_2, Consts.AUTHOR_OK_2.getAuthorSurname());
        assertEquals(Consts.AUTHOR_SURNAME_OK_3, Consts.AUTHOR_OK_3.getAuthorSurname());

        assertEquals(Consts.AUTHOR_NAME_OK_1, Consts.AUTHOR_OK_1.getAuthorName());
        assertEquals(Consts.AUTHOR_NAME_OK_2, Consts.AUTHOR_OK_2.getAuthorName());
        assertEquals(Consts.AUTHOR_NAME_ERROR_1, Consts.AUTHOR_ERROR_2.getAuthorName());
        assertEquals(Consts.AUTHOR_NAME_ERROR_2, Consts.AUTHOR_ERROR_3.getAuthorName());

        assertEquals(Consts.AUTHOR_PATRONYMIC_OK_1, Consts.AUTHOR_OK_1.getAuthorPatronymic());
        assertEquals(Consts.AUTHOR_PATRONYMIC_OK_2, Consts.AUTHOR_OK_2.getAuthorPatronymic());
        assertEquals(Consts.AUTHOR_PATRONYMIC_OK_3, Consts.AUTHOR_OK_3.getAuthorPatronymic());
        assertEquals(Consts.AUTHOR_PATRONYMIC_ERROR_1, Consts.AUTHOR_ERROR_4.getAuthorPatronymic());
    }

    @Test
    public void authorBuildOKTest() throws WrongDataException {
        Author author = Consts.AUTHOR_BUILDER.build(
                Consts.AUTHOR_ID_OK_1, Consts.AUTHOR_SURNAME_OK_1,
                Consts.AUTHOR_NAME_OK_1, Consts.AUTHOR_PATRONYMIC_OK_1);
        assertEquals(Consts.AUTHOR_ID_OK_1, author.getAuthorId());
        assertEquals(Consts.AUTHOR_SURNAME_OK_1, author.getAuthorSurname());
        assertEquals(Consts.AUTHOR_NAME_OK_1, author.getAuthorName());
        assertEquals(Consts.AUTHOR_PATRONYMIC_OK_1, author.getAuthorPatronymic());

        author = Consts.AUTHOR_BUILDER.build(
                Consts.AUTHOR_ID_OK_2, Consts.AUTHOR_SURNAME_OK_2,
                Consts.AUTHOR_NAME_OK_2, Consts.AUTHOR_PATRONYMIC_OK_2);
        assertEquals(Consts.AUTHOR_ID_OK_2, author.getAuthorId());
        assertEquals(Consts.AUTHOR_SURNAME_OK_2_CHECK, author.getAuthorSurname());
        assertEquals(Consts.AUTHOR_NAME_OK_2_CHECK, author.getAuthorName());
        assertEquals(Consts.AUTHOR_PATRONYMIC_OK_2_CHECK, author.getAuthorPatronymic());

        author = Consts.AUTHOR_BUILDER.build(
                Consts.AUTHOR_ID_OK_3, Consts.AUTHOR_SURNAME_OK_3,
                Consts.AUTHOR_NAME_OK_2, Consts.AUTHOR_PATRONYMIC_OK_3);
        assertEquals(Consts.AUTHOR_ID_OK_3, author.getAuthorId());
        assertEquals(Consts.AUTHOR_SURNAME_OK_3, author.getAuthorSurname());
        assertEquals(Consts.AUTHOR_NAME_OK_2_CHECK, author.getAuthorName());
        assertEquals(Consts.AUTHOR_PATRONYMIC_OK_3, author.getAuthorPatronymic());
    }

    @Test
    public void authorBuildWrongIdTest() throws WrongDataException {
        WrongDataException exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.AUTHOR_BUILDER.build(
                                Consts.AUTHOR_ID_ERROR_2,
                                Consts.AUTHOR_SURNAME_OK_1,
                                Consts.AUTHOR_NAME_OK_1,
                                Consts.AUTHOR_PATRONYMIC_OK_1),
                        "nothing");
        assertEquals("Ошибка в данных: authorId='-10'", exception.getMessage());
    }

    @Test
    public void authorBuildWrongSurnameTest() throws WrongDataException {
        WrongDataException exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.AUTHOR_BUILDER.build(
                                Consts.AUTHOR_ID_OK_1,
                                Consts.AUTHOR_SURNAME_ERROR_1,
                                Consts.AUTHOR_NAME_ERROR_1,
                                Consts.AUTHOR_PATRONYMIC_OK_1),
                        "nothing");
        assertEquals("Ошибка в данных: authorSurname=' '", exception.getMessage());
    }

    @Test
    public void authorBuildWrongNameTest() throws WrongDataException {
        WrongDataException exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.AUTHOR_BUILDER.build(
                                Consts.AUTHOR_ID_OK_1,
                                Consts.AUTHOR_SURNAME_OK_1,
                                Consts.AUTHOR_NAME_ERROR_1,
                                Consts.AUTHOR_PATRONYMIC_OK_1),
                        "nothing");
        assertEquals("Ошибка в данных: authorName='<null>'", exception.getMessage());

        exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.AUTHOR_BUILDER.build(
                                Consts.AUTHOR_ID_OK_1,
                                Consts.AUTHOR_SURNAME_OK_1,
                                Consts.AUTHOR_NAME_ERROR_2,
                                Consts.AUTHOR_PATRONYMIC_OK_1),
                        "nothing");
        assertEquals("Ошибка в данных: authorName=' '", exception.getMessage());
    }

    @Test
    public void authorBuildWrongPatronymicTest() throws WrongDataException {
        WrongDataException exception =
                assertThrows(
                        WrongDataException.class,
                        () -> Consts.AUTHOR_BUILDER.build(
                                Consts.AUTHOR_ID_OK_1,
                                Consts.AUTHOR_SURNAME_OK_1,
                                Consts.AUTHOR_NAME_OK_1,
                                Consts.AUTHOR_PATRONYMIC_ERROR_1),
                        "nothing");
        assertEquals("Ошибка в данных: authorPatronymic=' '", exception.getMessage());
    }
}
