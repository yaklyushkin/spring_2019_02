package yaklyushkin_otus.spring_2019_02.hw05.helpers.impl;

import yaklyushkin_otus.spring_2019_02.hw05.builders.BookBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.BookHelper;
import yaklyushkin_otus.spring_2019_02.hw05.service.BookService;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;

import java.util.List;

public class DefaultBookHelper implements BookHelper {

    public DefaultBookHelper(String language, MessageService msgService, BookService bookService) {
        this.bookBuilder = new BookBuilder(language, msgService);
        this.bookService = bookService;
    }

    @Override
    public Book create(String title) throws WrongDataException {
        Book book = this.bookBuilder.build(0, title);
        return this.bookService.insert(book);
    }

    @Override
    public Book change(long bookId, String title) throws WrongDataException {
        Book book = this.bookBuilder.build(bookId, title);
        return this.bookService.update(book);
    }

    @Override
    public Book remove(long bookId) {
        List<Author> authors = this.bookService.getAuthors(bookId);
        List<Genre> genres = this.bookService.getGenres(bookId);
        for (Author author : authors) {
            this.bookService.removeAuthorByIds(bookId, author.getAuthorId());
        }
        for (Genre genre : genres) {
            this.bookService.removeGenreByIds(bookId, genre.getGenreId());
        }
        return this.bookService.deleteById(bookId);
    }

    @Override
    public Book get(long bookId) {
        return this.bookService.getById(bookId);
    }

    @Override
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @Override
    public Book addAuthor(long bookId, long authorId) {
        return this.bookService.addAuthorByIds(bookId, authorId);
    }

    @Override
    public Book addGenre(long bookId, long genreId) {
        return this.bookService.addGenreByIds(bookId, genreId);
    }

    @Override
    public Book removeAuthor(long bookId, long authorId) {
        return this.bookService.removeAuthorByIds(bookId, authorId);
    }

    @Override
    public Book removeGenre(long bookId, long genreId) {
        return this.bookService.removeGenreByIds(bookId, genreId);
    }

    private final BookBuilder bookBuilder;

    private final BookService bookService;
}
