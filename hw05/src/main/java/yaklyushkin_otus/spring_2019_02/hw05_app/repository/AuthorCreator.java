package yaklyushkin_otus.spring_2019_02.hw05_app.repository;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorCreator {

    public static Author create(ResultSet resultSet, int i) throws SQLException {
        final long authorId = resultSet.getLong("author_id");
        final String authorSurname = resultSet.getString("author_surname");
        final String authorName = resultSet.getString("author_name");
        final String authorPatronymic = resultSet.getString("author_patronymic");
        return new Author(authorId, authorSurname, authorName, authorPatronymic);
    }
}
