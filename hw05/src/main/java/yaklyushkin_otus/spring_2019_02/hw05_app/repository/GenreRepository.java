package yaklyushkin_otus.spring_2019_02.hw05_app.repository;

import yaklyushkin_otus.spring_2019_02.hw05.dao.GenreDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

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
@Repository("genreRepository")
public class GenreRepository implements GenreDAO {

    public GenreRepository(NamedParameterJdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Genre insert(Genre Genre) {
        int GenreId = this.getMaxId();
        Genre = new Genre(GenreId, Genre.getGenreName());
        final Map<String, Object> parameters = this.construct(Genre);
        int recordsAffected = this.jdbcTemplate.update(
                "insert into genres (genre_id, genre_name) values (:genre_id, :genre_name)",
                parameters);
        return Genre;
    }

    @Override
    public Genre update(Genre Genre) {
        final Map<String, Object> parameters = this.construct(Genre);
        int recordsAffected = this.jdbcTemplate.update(
                "update genres set genre_name = :genre_name where genre_id = :genre_id",
                parameters);
        return Genre;
    }

    @Override
    public Genre delete(Genre Genre) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("genre_id", Genre.getGenreId());
        int recordsAffected =
                this.jdbcTemplate.update("delete from genres where genre_id = :genre_id", parameters);
        return Genre;
    }

    @Override
    public Genre deleteById(int GenreId) {
        final Genre Genre = this.getById(GenreId);
        return this.delete(Genre);
    }

    @Override
    public Genre getById(int GenreId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("genre_id", GenreId);
        return this.jdbcTemplate.queryForObject(
                "select * from genres where genre_id = :genre_id",
                parameters,
                new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        return this.jdbcTemplate.query("select * from genres", this.emptyMap, new GenreMapper());
    }

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject(
                "select count(*) from genres", this.emptyMap, Integer.class);
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            final int genreId = resultSet.getInt("genre_id");
            final String genreName = resultSet.getString("genre_name");
            return new Genre(genreId, genreName);
        }
    }

    private int getMaxId() {
        Integer maxId = this.jdbcTemplate.queryForObject(
                "select max(genre_id) from genres", this.emptyMap, Integer.class);
        if (maxId == null) {
            return 1;
        }
        return maxId + 1;
    }

    private Map<String, Object> construct(Genre Genre) {
        final HashMap<String, Object> parameters = new HashMap<>(1);
        parameters.put("genre_id", Genre.getGenreId());
        parameters.put("genre_name", Genre.getGenreName());
        return parameters;
    }

    private final NamedParameterJdbcOperations jdbcTemplate;

    private final Map<String, Object> emptyMap = Collections.emptyMap();
}
