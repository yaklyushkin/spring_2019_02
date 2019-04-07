package yaklyushkin_otus.spring_2019_02.hw05_app.repository;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreCreator {

    public static Genre create(ResultSet resultSet, int i) throws SQLException {
        final long genreId = resultSet.getLong("genre_id");
        final String genreName = resultSet.getString("genre_name");
        return new Genre(genreId, genreName);
    }
}
