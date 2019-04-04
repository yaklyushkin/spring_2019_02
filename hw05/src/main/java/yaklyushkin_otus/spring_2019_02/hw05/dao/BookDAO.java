package yaklyushkin_otus.spring_2019_02.hw05.dao;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BookDAO {

    Book insert(Book book);

    Book update(Book book);

    Book delete(Book book);

    Book deleteById(int bookId);

    Book addAuthor(Book book, Author author);

    Book addAuthorByAuthor(int bookId, Author author);

    Book addAuthorByIds(int bookId, int authorId);

    Book addAuthorByBook(Book book, int authorId);

    Book removeAuthor(Book book, Author author);

    Book removeAuthorByAuthor(int bookId, Author author);

    Book removeAuthorByIds(int bookId, int authorId);

    Book removeAuthorByBook(Book book, int authorId);

    Book addGenre(Book book, Genre genre);

    Book addGenreByGenre(int bookId, Genre genre);

    Book addGenreByIds(int bookId, int genreId);

    Book addGenreByBook(Book book, int genreId);

    Book removeGenre(Book book, Genre genre);

    Book removeGenreByGenre(int bookId, Genre genre);

    Book removeGenreByIds(int bookId, int genreId);

    Book removeGenreByBook(Book book, int genreId);

    Book getById(int bookId);

    List<Book> getAll();

    int count();

    List<Author> getAuthors(int bookId);

    List<Genre> getGenres(int bookId);
}
