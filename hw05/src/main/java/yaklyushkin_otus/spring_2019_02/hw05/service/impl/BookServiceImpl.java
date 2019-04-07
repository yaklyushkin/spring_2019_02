package yaklyushkin_otus.spring_2019_02.hw05.service.impl;

import yaklyushkin_otus.spring_2019_02.hw05.dao.BookDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.service.BookService;

import java.util.List;

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
    public Book deleteById(long bookId) {
        return this.dao.deleteById(bookId);
    }

    @Override
    public Book addAuthor(Book book, Author author) {
        return this.dao.addAuthor(book, author);
    }

    @Override
    public Book addAuthorByAuthor(long id, Author author) {
        return this.dao.addAuthorByAuthor(id, author);
    }

    @Override
    public Book addAuthorByIds(long bookId, long authorId) {
        return this.dao.addAuthorByIds(bookId, authorId);
    }

    @Override
    public Book addAuthorByBook(Book bookId, long authorId) {
        return this.dao.addAuthorByBook(bookId, authorId);
    }

    @Override
    public Book removeAuthor(Book book, Author author) {
        return this.dao.removeAuthor(book, author);
    }

    @Override
    public Book removeAuthorByAuthor(long id, Author author) {
        return this.dao.removeAuthorByAuthor(id, author);
    }

    @Override
    public Book removeAuthorByIds(long bookId, long authorId) {
        return this.dao.removeAuthorByIds(bookId, authorId);
    }

    @Override
    public Book removeAuthorByBook(Book bookId, long authorId) {
        return this.dao.removeAuthorByBook(bookId, authorId);
    }

    @Override
    public Book addGenre(Book book, Genre genre) {
        return this.dao.addGenre(book, genre);
    }

    @Override
    public Book addGenreByGenre(long id, Genre genre) {
        return this.dao.addGenreByGenre(id, genre);
    }

    @Override
    public Book addGenreByIds(long bookId, long genreId) {
        return this.dao.addGenreByIds(bookId, genreId);
    }

    @Override
    public Book addGenreByBook(Book bookId, long genreId) {
        return this.dao.addGenreByBook(bookId, genreId);
    }

    @Override
    public Book removeGenre(Book book, Genre genre) {
        return this.dao.removeGenre(book, genre);
    }

    @Override
    public Book removeGenreByGenre(long id, Genre genre) {
        return this.dao.removeGenreByGenre(id, genre);
    }

    @Override
    public Book removeGenreByIds(long bookId, long genreId) {
        return this.dao.removeGenreByIds(bookId, genreId);
    }

    @Override
    public Book removeGenreByBook(Book bookId, long genreId) {
        return this.dao.removeGenreByBook(bookId, genreId);
    }

    @Override
    public Book getById(long bookId) {
        return this.dao.getById(bookId);
    }

    @Override
    public List<Book> getAll() {
        return this.dao.getAll();
    }

    @Override
    public int count() {
        return this.dao.count();
    }

    @Override
    public List<Author> getAuthors(long bookId) {
        return this.dao.getAuthors(bookId);
    }

    @Override
    public List<Genre> getGenres(long bookId) {
        return this.dao.getGenres(bookId);
    }

    private final BookDAO dao;
}
