package yaklyushkin_otus.spring_2019_02.hw05.dao;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;

import java.util.List;

public interface AuthorDAO {

    Author insert(Author author);

    Author update(Author author);

    Author delete(Author author);

    Author deleteById(long authorId);

    Author getById(long authorId);

    List<Author> getAll();

    int count();
}
