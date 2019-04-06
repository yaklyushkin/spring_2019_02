package yaklyushkin_otus.spring_2019_02.hw05.dao;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;

import java.util.List;

public interface AuthorDAO {

    Author insert(Author author);

    Author update(Author author);

    Author delete(Author author);

    Author deleteById(int authorId);

    Author getById(int authorId);

    List<Author> getAll();

    int count();
}
