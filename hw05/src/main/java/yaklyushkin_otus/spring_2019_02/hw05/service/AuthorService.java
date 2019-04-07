package yaklyushkin_otus.spring_2019_02.hw05.service;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;

import java.util.List;

public interface AuthorService {

    Author insert(Author author);

    Author update(Author author);

    Author delete(Author author);

    Author deleteById(long authorId);

    Author getById(long authorId);

    List<Author> getAll();

    int count();
}
