package yaklyushkin_otus.spring_2019_02.hw05.service;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

public interface GenreService {

    Genre insert(Genre genre);

    Genre update(Genre genre);

    Genre delete(Genre genre);

    Genre deleteById(int genreId);
}
