package yaklyushkin_otus.spring_2019_02.hw05.builders;

import yaklyushkin_otus.spring_2019_02.hw05.consts.ErrorConsts;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Book;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;
import yaklyushkin_otus.spring_2019_02.hw05.utils.StrUtils;

import java.util.List;
import java.util.Locale;

public class BookBuilder {

    public BookBuilder(String language, MessageService msgService) {
        Locale locale = StrUtils.getLocale(language);
        this.msgErrorBookId = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_BOOK_ID, null, locale);
        this.msgErrorTitle = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_BOOK_TITLE, null, locale);
    }

    public final Book build(
            int bookId, String title, List<Author> authors, List<Genre> genres) throws WrongDataException {
        this.checkId(bookId);
        this.checkTitle(title);
        title = StrUtils.capitalize(StrUtils.toOnlyOneInnerSpaceWithTrim(title));
        return new Book(bookId, title, authors, genres);
    }

    private void checkId(int genreId) throws WrongDataException {
        if (genreId < 0) {
            throw new WrongDataException(String.format(this.msgErrorBookId, genreId));
        }
    }

    private void checkTitle(String title) throws WrongDataException {
        if (title == null) {
            throw new WrongDataException(String.format(this.msgErrorTitle, "<null>"));
        } else if (StrUtils.isBlank(title)) {
            throw new WrongDataException(String.format(this.msgErrorTitle, title));
        }
    }

    private final String msgErrorBookId;

    private final String msgErrorTitle;
}
