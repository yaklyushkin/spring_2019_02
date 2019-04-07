package yaklyushkin_otus.spring_2019_02.hw05.helpers;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;

import java.util.List;

public interface GenreHelper {

    Genre create(String genreName) throws WrongDataException;

    Genre change(long genreId, String genreName) throws WrongDataException;

    Genre remove(long genreId);

    Genre get(long genreId);

    List<Genre> getAll();
}
