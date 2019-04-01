package yaklyushkin_otus.spring_2019_02.hw05.service;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;

public interface AuthorService {

    Author insert(Author author);

    Author update(Author author);

    Author delete(Author author);

    Author deleteById(int authorId);
}
