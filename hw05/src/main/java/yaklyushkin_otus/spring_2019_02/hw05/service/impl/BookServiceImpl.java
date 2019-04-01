package yaklyushkin_otus.spring_2019_02.hw05.service.impl;

import yaklyushkin_otus.spring_2019_02.hw05.dao.BookDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.service.BookService;

public class BookServiceImpl implements BookService {

    public BookServiceImpl(BookDAO dao) {
        this.dao = dao;
    }

    @Override
    public Book insert(Book book) {
        return this.dao.insert(book);
    }

    @Override
    public Book update(Book book) {
        return this.dao.update(book);
    }

    @Override
    public Book delete(Book book) {
        return this.dao.delete(book);
    }

    @Override
    public Book deleteById(int bookId) {
        return this.dao.deleteById(bookId);
    }

    @Override
    public Book addAuthor(Book book, Author author) {
        return this.dao.addAuthor(book, author);
    }

    @Override
    public Book addAuthorByAuthor(int id, Author author) {
        return this.dao.addAuthorByAuthor(id, author);
    }

    @Override
    public Book addAuthorByIds(int bookId, int authorId) {
        return this.dao.addAuthorByIds(bookId, authorId);
    }

    @Override
    public Book addAuthorByBook(Book bookId, int authorId) {
        return this.dao.addAuthorByBook(bookId, authorId);
    }

    @Override
    public Book removeAuthor(Book book, Author author) {
        return this.dao.removeAuthor(book, author);
    }

    @Override
    public Book removeAuthorByAuthor(int id, Author author) {
        return this.dao.removeAuthorByAuthor(id, author);
    }

    @Override
    public Book removeAuthorByIds(int bookId, int authorId) {
        return this.dao.removeAuthorByIds(bookId, authorId);
    }

    @Override
    public Book removeAuthorByBook(Book bookId, int authorId) {
        return this.dao.removeAuthorByBook(bookId, authorId);
    }

    @Override
    public Book addGenre(Book book, Genre genre) {
        return this.dao.addGenre(book, genre);
    }

    @Override
    public Book addGenreByGenre(int id, Genre genre) {
        return this.dao.addGenreByGenre(id, genre);
    }

    @Override
    public Book addGenreByIds(int bookId, int genreId) {
        return this.dao.addGenreByIds(bookId, genreId);
    }

    @Override
    public Book addGenreByBook(Book bookId, int genreId) {
        return this.dao.addGenreByBook(bookId, genreId);
    }

    @Override
    public Book removeGenre(Book book, Genre genre) {
        return this.dao.removeGenre(book, genre);
    }

    @Override
    public Book removeGenreByGenre(int id, Genre genre) {
        return this.dao.removeGenreByGenre(id, genre);
    }

    @Override
    public Book removeGenreByIds(int bookId, int genreId) {
        return this.dao.removeGenreByIds(bookId, genreId);
    }

    @Override
    public Book removeGenreByBook(Book bookId, int genreId) {
        return this.dao.removeGenreByBook(bookId, genreId);
    }

    private final BookDAO dao;
}
