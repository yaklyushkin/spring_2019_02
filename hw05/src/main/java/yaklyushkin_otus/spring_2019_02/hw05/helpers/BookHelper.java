package yaklyushkin_otus.spring_2019_02.hw05.helpers;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;

import java.util.List;

public interface BookHelper {

    Book create(String title) throws WrongDataException;

    Book change(long bookId, String title) throws WrongDataException;

    Book remove(long bookId);

    Book get(long bookId);

    List<Book> getAll();

    Book addAuthor(long bookId, long authorId);

    Book addGenre(long bookId, long genreId);

    Book removeAuthor(long bookId, long authorId);

    Book removeGenre(long bookId, long genreId);
}
