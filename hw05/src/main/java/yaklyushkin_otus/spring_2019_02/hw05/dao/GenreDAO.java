package yaklyushkin_otus.spring_2019_02.hw05.dao;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

import java.util.List;

public interface GenreDAO {

    Genre insert(Genre genre);

    Genre update(Genre genre);

    Genre delete(Genre genre);

    Genre deleteById(int genreId);

    Genre getById(int genreId);

    List<Genre> getAll();

    int count();
}
