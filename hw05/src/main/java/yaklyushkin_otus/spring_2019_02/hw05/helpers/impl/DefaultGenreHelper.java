package yaklyushkin_otus.spring_2019_02.hw05.helpers.impl;

import yaklyushkin_otus.spring_2019_02.hw05.builders.GenreBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.GenreHelper;
import yaklyushkin_otus.spring_2019_02.hw05.service.GenreService;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;

import java.util.List;

public class DefaultGenreHelper implements GenreHelper {

    public DefaultGenreHelper(String language, MessageService msgService, GenreService genreService) {
        this.genreBuilder = new GenreBuilder(language, msgService);
        this.genreService = genreService;
    }

    @Override
    public Genre create(String genreName) throws WrongDataException {
        Genre genre = this.genreBuilder.build(0, genreName);
        return this.genreService.insert(genre);
    }

    @Override
    public Genre change(int genreId, String genreName) throws WrongDataException {
        Genre genre = this.genreBuilder.build(genreId, genreName);
        return this.genreService.update(genre);
    }

    @Override
    public Genre remove(int genreId) {
        return this.genreService.deleteById(genreId);
    }

    @Override
    public Genre get(int genreId) {
        return this.genreService.getById(genreId);
    }

    @Override
    public List<Genre> getAll() {
        return this.genreService.getAll();
    }

    private final GenreBuilder genreBuilder;

    private final GenreService genreService;
}
