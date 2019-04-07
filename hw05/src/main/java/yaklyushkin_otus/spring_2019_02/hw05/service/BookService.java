package yaklyushkin_otus.spring_2019_02.hw05.service;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

import java.util.List;

public interface BookService {

    Book insert(Book book);

    Book update(Book book);

    Book delete(Book book);

    Book deleteById(long bookId);

    Book addAuthor(Book book, Author author);

    Book addAuthorByAuthor(long id, Author author);

    Book addAuthorByIds(long bookId, long authorId);

    Book addAuthorByBook(Book bookId, long authorId);

    Book removeAuthor(Book book, Author author);

    Book removeAuthorByAuthor(long id, Author author);

    Book removeAuthorByIds(long bookId, long authorId);

    Book removeAuthorByBook(Book bookId, long authorId);

    Book addGenre(Book book, Genre genre);

    Book addGenreByGenre(long id, Genre genre);

    Book addGenreByIds(long bookId, long genreId);

    Book addGenreByBook(Book bookId, long genreId);

    Book removeGenre(Book book, Genre genre);

    Book removeGenreByGenre(long id, Genre genre);

    Book removeGenreByIds(long bookId, long genreId);

    Book removeGenreByBook(Book bookId, long genreId);

    Book getById(long bookId);

    List<Book> getAll();

    int count();

    List<Author> getAuthors(long bookId);

    List<Genre> getGenres(long bookId);
}
