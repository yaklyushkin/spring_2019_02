package yaklyushkin_otus.spring_2019_02.hw05_app.shell;

import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.AuthorHelper;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.BookHelper;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.GenreHelper;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.StringDataHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Hw05Shell {

    public Hw05Shell(
            @Autowired AuthorHelper authorHelper,
            @Autowired BookHelper bookHelper,
            @Autowired GenreHelper genreHelper) {
        this.authorHelper = authorHelper;
        this.bookHelper = bookHelper;
        this.genreHelper = genreHelper;
    }

    @ShellMethod("List records (-t --table table name: authors, books, genres).")
    public String list(@ShellOption({"-t", "--table"}) String table) {
        String result;
        if ("authors".equals(table)) {
            StringBuilder sb = new StringBuilder();
            for (Author author : this.authorHelper.getAll()) {
                sb.append(author.toString());
                sb.append("\n");
            }
            result = sb.toString();
        } else if ("books".equals(table)) {
            StringBuilder sb = new StringBuilder();
            for (Book book : this.bookHelper.getAll()) {
                sb.append(book.toString());
                sb.append("\n");
            }
            result = sb.toString();
        } else if ("genres".equals(table)) {
            StringBuilder sb = new StringBuilder();
            for (Genre genre : this.genreHelper.getAll()) {
                sb.append(genre.toString());
                sb.append("\n");
            }
            result = sb.toString();
        } else {
            result = "Wrong table!";
        }
        return result;
    }

    @ShellMethod(
            value = "Create author (-s --surname surname, -n --name name, -p --patronymic patronymic)).",
            key = "add_author")
    public String addAuthor(
            @ShellOption(value = {"-s", "--surname"}) String surname,
            @ShellOption(value = {"-n", "--name"}) String name,
            @ShellOption(value = {"-p", "--patronymic"}) String patronymic) throws WrongDataException {
        String result;
        Author author = this.authorHelper.create(surname, name, patronymic);
        if (author != null) {
            result = author.toString();
        } else {
            result = "Author was not created!";
        }
        return result;
    }

    @ShellMethod(value = "Create book (-t --title bookTitle).", key = "add_book")
    public String addBook(@ShellOption({"-t", "--title"}) String title) throws WrongDataException {
        String result;
        Book book = this.bookHelper.create(title);
        if (book != null) {
            result = book.toString();
        } else {
            result = "Book was not created!";
        }
        return result;
    }

    @ShellMethod(value = "Create genre (-n --name genreName).", key = "add_genre")
    public String addGenre(@ShellOption({"-n", "--name"}) String name) throws WrongDataException {
        String result;
        Genre genre = this.genreHelper.create(name);
        if (genre != null) {
            result = genre.toString();
        } else {
            result = "Genre was not created!";
        }
        return result;
    }

    @ShellMethod(
            value = "Change author (-i --id authorId, -s --surname surname, -n --name name, -p --patronymic patronymic).",
            key = "up_author")
    public String changeAuthor(
            @ShellOption(value = {"-i", "--id"}) long authorId,
            @ShellOption(value = {"-s", "--surname"}, defaultValue = DEFAULT_OPTION_STRING_VALUE) String surname,
            @ShellOption(value = {"-n", "--name"}, defaultValue = DEFAULT_OPTION_STRING_VALUE) String name,
            @ShellOption(value = {"-p", "--patronymic"}, defaultValue = DEFAULT_OPTION_STRING_VALUE) String patronymic)
            throws WrongDataException {
        String result;
        StringDataHolder authorSurname =
                new StringDataHolder(surname, (!DEFAULT_OPTION_STRING_VALUE.equals(surname)));
        StringDataHolder authorName =
                new StringDataHolder(name, (!DEFAULT_OPTION_STRING_VALUE.equals(name)));
        StringDataHolder authorPatronymic =
                new StringDataHolder(patronymic, (!DEFAULT_OPTION_STRING_VALUE.equals(patronymic)));
        Author author = this.authorHelper.change(authorId, authorSurname, authorName, authorPatronymic);
        if (author != null) {
            result = author.toString();
        } else {
            result = "Author was not changed!";
        }
        return result;
    }

    @ShellMethod(value = "Change book (-i --id bookId, -t --title title).", key = "up_book")
    public String changeBook(
            @ShellOption(value = {"-i", "--id"}) long bookId,
            @ShellOption({"-t", "--title"}) String title)
            throws WrongDataException {
        String result;
        Book book = this.bookHelper.change(bookId, title);
        if (book != null) {
            result = book.toString();
        } else {
            result = "Book was not changed!";
        }
        return result;
    }

    @ShellMethod(value = "Change genre (-i --id genreId, -n --name genreName).", key = "up_genre")
    public String changeGenre(
            @ShellOption(value = {"-i", "--id"}) long genreId,
            @ShellOption({"-n", "--name"}) String name)
            throws WrongDataException {
        String result;
        Genre genre = this.genreHelper.change(genreId, name);
        if (genre != null) {
            result = genre.toString();
        } else {
            result = "Genre was not changed!";
        }
        return result;
    }

    @ShellMethod(value = "Add author to book (-i --id bookId, -a --author-id authorId).", key = "add_book_author")
    public String addAuthorToBook(
            @ShellOption(value = {"-i", "--id"}) long bookId,
            @ShellOption(value = {"-a", "--author-id"}) long authorId) {
        String result;
        Book book = this.bookHelper.addAuthor(bookId, authorId);
        if (book != null) {
            result = book.toString();
        } else {
            result = "Author was not added!";
        }
        return result;
    }

    @ShellMethod(value = "Add genre to book (-i --id bookId, -g --genre-id genreId).", key = "add_book_genre")
    public String addGenreToBook(
            @ShellOption(value = {"-i", "--id"}) long bookId,
            @ShellOption(value = {"-a", "--genre-id"}) long genreId) {
        String result;
        Book book = this.bookHelper.addGenre(bookId, genreId);
        if (book != null) {
            result = book.toString();
        } else {
            result = "Genre was not added!";
        }
        return result;
    }

    @ShellMethod(value = "Remove author from book (-i --id bookId, -a --author-id authorId).", key = "rm_book_author")
    public String removeAuthorFromBook(
            @ShellOption(value = {"-i", "--id"}) long bookId,
            @ShellOption(value = {"-a", "--author-id"}) long authorId) {
        String result;
        Book book = this.bookHelper.removeAuthor(bookId, authorId);
        if (book != null) {
            result = book.toString();
        } else {
            result = "Author was not removed!";
        }
        return result;
    }

    @ShellMethod(value = "Remove genre from book (-i --id bookId, -g --genre-id genreId).", key = "rm_book_genre")
    public String removeGenreFromBook(
            @ShellOption(value = {"-i", "--id"}) long bookId,
            @ShellOption(value = {"-g", "--genre-id"}) long genreId) {
        String result;
        Book book = this.bookHelper.removeGenre(bookId, genreId);
        if (book != null) {
            result = book.toString();
        } else {
            result = "Genre was not removed!";
        }
        return result;
    }

    @ShellMethod(value = "Remove author (-i --id authorId).", key = "rm_author")
    public String removeAuthor(@ShellOption(value = {"-i", "--id"}) long authorId) {
        String result;
        Author author = this.authorHelper.remove(authorId);
        if (author != null) {
            result = author.toString();
        } else {
            result = "Author was not removed!";
        }
        return result;
    }

    @ShellMethod(value = "Remove book (-i --id bookId).", key = "rm_book")
    public String removeBook(@ShellOption(value = {"-i", "--id"}) long bookId) {
        String result;
        Book book = this.bookHelper.remove(bookId);
        if (book != null) {
            result = book.toString();
        } else {
            result = "Book was not removed!";
        }
        return result;
    }

    @ShellMethod(value = "Remove genre (-i --id genreId).", key = "rm_genre")
    public String removeGenre(@ShellOption(value = {"-i", "--id"}) long genreId) {
        String result;
        Genre genre = this.genreHelper.remove(genreId);
        if (genre != null) {
            result = genre.toString();
        } else {
            result = "Genre was not removed!";
        }
        return result;
    }

    private static final String DEFAULT_OPTION_STRING_VALUE = "<*none*>";

    private final AuthorHelper authorHelper;

    private final BookHelper bookHelper;

    private final GenreHelper genreHelper;
}
