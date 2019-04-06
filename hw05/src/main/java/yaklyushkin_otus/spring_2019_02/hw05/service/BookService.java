package yaklyushkin_otus.spring_2019_02.hw05.service;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

import java.util.List;

public interface BookService {

    Book insert(Book book);

    Book update(Book book);

    Book delete(Book book);

    Book deleteById(int bookId);

    Book addAuthor(Book book, Author author);

    Book addAuthorByAuthor(int id, Author author);

    Book addAuthorByIds(int bookId, int authorId);

    Book addAuthorByBook(Book bookId, int authorId);

    Book removeAuthor(Book book, Author author);

    Book removeAuthorByAuthor(int id, Author author);

    Book removeAuthorByIds(int bookId, int authorId);

    Book removeAuthorByBook(Book bookId, int authorId);

    Book addGenre(Book book, Genre genre);

    Book addGenreByGenre(int id, Genre genre);

    Book addGenreByIds(int bookId, int genreId);

    Book addGenreByBook(Book bookId, int genreId);

    Book removeGenre(Book book, Genre genre);

    Book removeGenreByGenre(int id, Genre genre);

    Book removeGenreByIds(int bookId, int genreId);

    Book removeGenreByBook(Book bookId, int genreId);

    Book getById(int bookId);

    List<Book> getAll();

    int count();

    List<Author> getAuthors(int bookId);

    List<Genre> getGenres(int bookId);
}
