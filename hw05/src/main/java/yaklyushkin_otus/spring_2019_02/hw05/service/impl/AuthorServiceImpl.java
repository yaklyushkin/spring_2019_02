package yaklyushkin_otus.spring_2019_02.hw05.service.impl;

import yaklyushkin_otus.spring_2019_02.hw05.dao.AuthorDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.service.AuthorService;

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

    private final AuthorDAO dao;
}
