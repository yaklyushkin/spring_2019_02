package yaklyushkin_otus.spring_2019_02.hw05_app.repository;

import yaklyushkin_otus.spring_2019_02.hw05.dao.AuthorDAO;
import yaklyushkin_otus.spring_2019_02.hw05.dao.BookDAO;
import yaklyushkin_otus.spring_2019_02.hw05.dao.GenreDAO;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository("bookRepository")
public class BookRepository implements BookDAO {

    public BookRepository(
            NamedParameterJdbcOperations jdbcTemplate, AuthorDAO authorDAO, GenreDAO genreDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorDAO = authorDAO;
        this.genreDAO = genreDAO;
    }

    @Override
    public Book insert(Book book) {
        int bookId = this.getMaxId();
        book = new Book(bookId, book.getTitle(), book.getAuthors(), book.getGenres());
        final Map<String, Object> parameters = this.construct(book);
        int recordsAffected = this.jdbcTemplate.update(
                "insert into books (book_id, title) values (:book_id, :title)",
                parameters);
        this.updateAuthors(book);
        this.updateGenres(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        final Map<String, Object> parameters = this.construct(book);
        int recordsAffected = this.jdbcTemplate.update(
                "update books set title = :title where book_id = :book_id",
                parameters);
        this.updateAuthors(book);
        this.updateGenres(book);
        return book;
    }

    @Override
    public Book delete(Book book) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", book.getBookId());
        int recordsAffected =
                this.jdbcTemplate.update("delete from books where book_id = :book_id", parameters);
        return book;
    }

    @Override
    public Book deleteById(int bookId) {
        final Book book = this.getById(bookId);
        return this.delete(book);
    }

    @Override
    public Book addAuthor(Book book, Author author) {
        return this.addAuthorByIds(book.getBookId(), author.getAuthorId());
    }

    @Override
    public Book addAuthorByAuthor(int bookId, Author author) {
        return this.addAuthorByIds(bookId, author.getAuthorId());
    }

    @Override
    public Book addAuthorByIds(int bookId, int authorId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", bookId);
        parameters.put("author_id", authorId);
        int affectedRows = this.jdbcTemplate.update(
                "insert into book_r_author (book_id, author_id) values (:book_id, :author_id)",
                parameters);
        return this.getById(bookId);
    }

    @Override
    public Book addAuthorByBook(Book book, int authorId) {
        return this.addAuthorByIds(book.getBookId(), authorId);
    }

    @Override
    public Book removeAuthor(Book book, Author author) {
        return this.removeAuthorByIds(book.getBookId(), author.getAuthorId());
    }

    @Override
    public Book removeAuthorByAuthor(int bookId, Author author) {
        return this.removeAuthorByIds(bookId, author.getAuthorId());
    }

    @Override
    public Book removeAuthorByIds(int bookId, int authorId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", bookId);
        parameters.put("author_id", authorId);
        int affectedRows = this.jdbcTemplate.update(
                "delete from book_r_author where book_id = :book_id and author_id = :author_id",
                parameters);
        return this.getById(bookId);
    }

    @Override
    public Book removeAuthorByBook(Book book, int authorId) {
        return this.removeAuthorByIds(book.getBookId(), authorId);
    }

    @Override
    public Book addGenre(Book book, Genre genre) {
        return this.addGenreByIds(book.getBookId(), genre.getGenreId());
    }

    @Override
    public Book addGenreByGenre(int bookId, Genre genre) {
        return this.addGenreByIds(bookId, genre.getGenreId());
    }

    @Override
    public Book addGenreByIds(int bookId, int genreId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", bookId);
        parameters.put("genre_id", genreId);
        int affectedRows = this.jdbcTemplate.update(
                "insert into book_r_genre (book_id, genre_id) values (:book_id, :genre_id)",
                parameters);
        return this.getById(bookId);
    }

    @Override
    public Book addGenreByBook(Book book, int genreId) {
        return this.addGenreByIds(book.getBookId(), genreId);
    }

    @Override
    public Book removeGenre(Book book, Genre genre) {
        return this.removeGenreByIds(book.getBookId(), genre.getGenreId());
    }

    @Override
    public Book removeGenreByGenre(int bookId, Genre genre) {
        return this.removeGenreByIds(bookId, genre.getGenreId());
    }

    @Override
    public Book removeGenreByIds(int bookId, int genreId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", bookId);
        parameters.put("genre_id", genreId);
        int affectedRows = this.jdbcTemplate.update(
                "delete from book_r_genre where book_id = :book_id and genre_id = :genre_id",
                parameters);
        return this.getById(bookId);
    }

    @Override
    public Book removeGenreByBook(Book book, int genreId) {
        return this.removeGenreByIds(book.getBookId(), genreId);
    }

    @Override
    public Book getById(int bookId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", bookId);
        return this.jdbcTemplate.queryForObject(
                "select * from books where book_id = :book_id",
                parameters,
                new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        return this.jdbcTemplate.query("select * from books", this.emptyMap, new BookMapper());
    }

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject(
                "select count(*) from books", this.emptyMap, Integer.class);
    }

    @Override
    public List<Author> getAuthors(int bookId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", bookId);
        List<Integer> authorsIds = this.jdbcTemplate.queryForList(
                "select author_id from book_r_author where book_id = :book_id",
                parameters, Integer.class);
        List<Author> result = new ArrayList<>(authorsIds.size());
        for (int authorId : authorsIds) {
            result.add(this.authorDAO.getById(authorId));
        }
        return result;
    }

    @Override
    public List<Genre> getGenres(int bookId) {
        final Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", bookId);
        List<Integer> genreIds = this.jdbcTemplate.queryForList(
                "select genre_id from book_r_genre where book_id = :book_id",
                parameters, Integer.class);
        List<Genre> result = new ArrayList<>(genreIds.size());
        for (int genreId : genreIds) {
            result.add(this.genreDAO.getById(genreId));
        }
        return result;
    }

    private class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            final int bookId = resultSet.getInt("book_id");
            final String title = resultSet.getString("title");
            List<Author> authors = getAuthors(bookId);
            List<Genre> genres = getGenres(bookId);
            return new Book(bookId, title, authors, genres);
        }
    }

    private int getMaxId() {
        Integer maxId = this.jdbcTemplate.queryForObject(
                "select max(book_id) from books", this.emptyMap, Integer.class);
        if (maxId == null) {
            return 1;
        }
        return maxId + 1;
    }

    private Map<String, Object> construct(Book book) {
        final HashMap<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", book.getBookId());
        parameters.put("title", book.getTitle());
        return parameters;
    }

    private void updateAuthors(Book book) {
        final HashMap<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", book.getBookId());
        this.jdbcTemplate.update(
                "delete from book_r_author where book_id = :book_id",
                parameters);
        for (Author author : book.getAuthors()) {
            this.addAuthorByIds(book.getBookId(), author.getAuthorId());
        }
    }

    private void updateGenres(Book book) {
        final HashMap<String, Object> parameters = new HashMap<>(1);
        parameters.put("book_id", book.getBookId());
        this.jdbcTemplate.update(
                "delete from book_r_genre where book_id = :book_id",
                parameters);
        for (Genre genre : book.getGenres()) {
            this.addGenreByIds(book.getBookId(), genre.getGenreId());
        }
    }

    private final NamedParameterJdbcOperations jdbcTemplate;

    private final Map<String, Object> emptyMap = Collections.emptyMap();

    private final AuthorDAO authorDAO;

    private final GenreDAO genreDAO;
}
