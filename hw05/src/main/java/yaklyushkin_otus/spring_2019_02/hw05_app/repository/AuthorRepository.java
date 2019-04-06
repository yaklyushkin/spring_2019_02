package yaklyushkin_otus.spring_2019_02.hw05_app.repository;

import yaklyushkin_otus.spring_2019_02.hw05.dao.AuthorDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository("authorRepository")
public class AuthorRepository implements AuthorDAO {

    public AuthorRepository(NamedParameterJdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author insert(Author author) {
        int authorId = this.getMaxId();
        author = new Author(authorId,
                author.getAuthorSurname(), author.getAuthorName(), author.getAuthorPatronymic());
        final Map<String, Object> parameters = this.construct(author);
        int recordsAffected = this.jdbcTemplate.update(
                "insert into authors (author_id, author_surname, author_name, author_patronymic) " +
                        " values (:author_id, :author_surname, :author_name, :author_patronymic)",
                parameters);
        return author;
    }

    @Override
    public Author update(Author author) {
        final Map<String, Object> parameters = this.construct(author);
        int recordsAffected = this.jdbcTemplate.update(
                "update authors set author_surname = :author_surname, author_name = :author_name, " +
                        "author_patronymic = :author_patronymic where author_id = :author_id",
                parameters);
        return author;
    }

    @Override
    public Author delete(Author author) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("author_id", author.getAuthorId());
        int recordsAffected =
                this.jdbcTemplate.update("delete from authors where author_id = :author_id", parameters);
        return author;
    }

    @Override
    public Author deleteById(int authorId) {
        final Author author = this.getById(authorId);
        return this.delete(author);
    }

    @Override
    public Author getById(int authorId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("author_id", authorId);
        return this.jdbcTemplate.queryForObject(
                "select * from authors where author_id = :author_id",
                parameters,
                new AuthorMapper());
    }

    @Override
    public List<Author> getAll() {
        return this.jdbcTemplate.query("select * from authors", this.emptyMap, new AuthorMapper());
    }

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject(
                "select count(*) from authors", this.emptyMap, Integer.class);
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            final int authorId = resultSet.getInt("author_id");
            final String authorSurname = resultSet.getString("author_surname");
            final String authorName = resultSet.getString("author_name");
            final String authorPatronymic = resultSet.getString("author_patronymic");
            return new Author(authorId, authorSurname, authorName, authorPatronymic);
        }
    }

    private int getMaxId() {
        Integer maxId = this.jdbcTemplate.queryForObject(
                "select max(author_id) from authors", this.emptyMap, Integer.class);
        if (maxId == null) {
            return 1;
        }
        return maxId + 1;
    }

    private Map<String, Object> construct(Author author) {
        final HashMap<String, Object> parameters = new HashMap<>(1);
        parameters.put("author_id", author.getAuthorId());
        parameters.put("author_surname", author.getAuthorSurname());
        parameters.put("author_name", author.getAuthorName());
        parameters.put("author_patronymic", author.getAuthorPatronymic());
        return parameters;
    }

    private final NamedParameterJdbcOperations jdbcTemplate;

    private final Map<String, Object> emptyMap = Collections.emptyMap();
}
