package yaklyushkin_otus.spring_2019_02.hw05.helpers;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;

import java.util.List;

public interface BookHelper {

    Book create(String title) throws WrongDataException;

    Book change(int bookId, String title) throws WrongDataException;

    Book remove(int bookId);

    Book get(int bookId);

    List<Book> getAll();

    Book addAuthor(int bookId, int authorId);

    Book addGenre(int bookId, int genreId);

    Book removeAuthor(int bookId, int authorId);

    Book removeGenre(int bookId, int genreId);
}
