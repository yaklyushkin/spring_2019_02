package yaklyushkin_otus.spring_2019_02.hw05.service.impl;

import yaklyushkin_otus.spring_2019_02.hw05.dao.AuthorDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    public AuthorServiceImpl(AuthorDAO dao) {
        this.dao = dao;
    }

    @Override
    public Author insert(Author author) {
        return this.dao.insert(author);
    }

    @Override
    public Author update(Author author) {
        return this.dao.update(author);
    }

    @Override
    public Author delete(Author author) {
        return this.dao.delete(author);
    }

    @Override
    public Author deleteById(int authorId) {
        return this.dao.deleteById(authorId);
    }

    @Override
    public Author getById(int authorId) {
        return this.dao.getById(authorId);
    }

    @Override
    public List<Author> getAll() {
        return this.dao.getAll();
    }

    @Override
    public int count() {
        return this.dao.count();
    }

    private final AuthorDAO dao;
}
