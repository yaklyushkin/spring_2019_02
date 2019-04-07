package yaklyushkin_otus.spring_2019_02.hw05.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Book {

    public Book(long bookId, String title, List<Author> authors, List<Genre> genres) {
        this.bookId = bookId;
        this.title = title;
        this.authors = Collections.unmodifiableList(authors);
        this.genres = Collections.unmodifiableList(genres);
    }

    public long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other == null) ||
            (getClass() != other.getClass())) {
            return false;
        }
        Book book = (Book) other;
        return (bookId == book.bookId) &&
               (Objects.equals(title, book.title)) &&
               (Objects.equals(authors, book.authors)) &&
               (Objects.equals(genres, book.genres));
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, authors, genres);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }

    private final long bookId;

    private final String title;

    private final List<Author> authors;

    private final List<Genre> genres;
}
