package yaklyushkin_otus.spring_2019_02.hw05.helpers;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;

import java.util.List;

public interface AuthorHelper {

    Author create(String authorSurname, String authorName, String authorPatronymic)
            throws WrongDataException;

    Author change(int authorId, StringDataHolder authorSurname, StringDataHolder authorName,
                  StringDataHolder authorPatronymic) throws WrongDataException;

    Author remove(int authorId);

    Author get(int authorId);

    List<Author> getAll();
}
