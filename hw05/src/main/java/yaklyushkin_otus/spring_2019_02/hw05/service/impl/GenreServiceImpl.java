package yaklyushkin_otus.spring_2019_02.hw05.service.impl;

import yaklyushkin_otus.spring_2019_02.hw05.dao.GenreDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.service.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService {

    public GenreServiceImpl(GenreDAO dao) {
        this.dao = dao;
    }

    @Override
    public Genre insert(Genre genre) {
        return this.dao.insert(genre);
    }

    @Override
    public Genre update(Genre genre) {
        return this.dao.update(genre);
    }

    @Override
    public Genre delete(Genre genre) {
        return this.dao.delete(genre);
    }

    @Override
    public Genre deleteById(int genreId) {
        return this.dao.deleteById(genreId);
    }

    @Override
    public Genre getById(int genreId) {
        return this.dao.getById(genreId);
    }

    @Override
    public List<Genre> getAll() {
        return this.dao.getAll();
    }

    @Override
    public int count() {
        return this.dao.count();
    }

    private final GenreDAO dao;
}
