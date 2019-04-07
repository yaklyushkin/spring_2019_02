package yaklyushkin_otus.spring_2019_02.hw05.dao;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

import java.util.List;

public interface BookDAO {

    Book insert(Book book);

    Book update(Book book);

    Book delete(Book book);

    Book deleteById(long bookId);

    Book addAuthor(Book book, Author author);

    Book addAuthorByAuthor(long bookId, Author author);

    Book addAuthorByIds(long bookId, long authorId);

    Book addAuthorByBook(Book book, long authorId);

    Book removeAuthor(Book book, Author author);

    Book removeAuthorByAuthor(long bookId, Author author);

    Book removeAuthorByIds(long bookId, long authorId);

    Book removeAuthorByBook(Book book, long authorId);

    Book addGenre(Book book, Genre genre);

    Book addGenreByGenre(long bookId, Genre genre);

    Book addGenreByIds(long bookId, long genreId);

    Book addGenreByBook(Book book, long genreId);

    Book removeGenre(Book book, Genre genre);

    Book removeGenreByGenre(long bookId, Genre genre);

    Book removeGenreByIds(long bookId, long genreId);

    Book removeGenreByBook(Book book, long genreId);

    Book getById(long bookId);

    List<Book> getAll();

    int count();

    List<Author> getAuthors(long bookId);

    List<Genre> getGenres(long bookId);
}
