package yaklyushkin_otus.spring_2019_02.hw05.builders;

import yaklyushkin_otus.spring_2019_02.hw05.consts.ErrorConsts;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;
import yaklyushkin_otus.spring_2019_02.hw05.utils.StrUtils;

import java.util.Locale;

public class AuthorBuilder {

    public AuthorBuilder(String language, MessageService msgService) {
        Locale locale = StrUtils.getLocale(language);
        this.msgErrorAuthorId = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_ID, null, locale);
        this.msgErrorAuthorSurname = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_SURNAME, null, locale);
        this.msgErrorAuthorName = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_NAME, null, locale);
        this.msgErrorAuthorPatronymic = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_PATRONYMIC, null, locale);
    }

    public final Author build(long authorId, String authorSurname,
                              String authorName, String authorPatronymic) throws WrongDataException {
        this.checkId(authorId);
        this.checkSurname(authorSurname);
        this.checkName(authorName);
        this.checkPatronymic(authorPatronymic);

        authorSurname = StrUtils.toCamelCase(StrUtils.toOnlyOneInnerSpaceWithTrim(authorSurname));
        authorName = StrUtils.toCamelCase(StrUtils.toOnlyOneInnerSpaceWithTrim(authorName));
        authorPatronymic = StrUtils.toCamelCase(StrUtils.toOnlyOneInnerSpaceWithTrim(authorPatronymic));

        return new Author(authorId, authorSurname, authorName, authorPatronymic);
    }

    private void checkId(long authorId) throws WrongDataException {
        if (authorId < 0) {
            throw new WrongDataException(String.format(this.msgErrorAuthorId, authorId));
        }
    }
    private void checkSurname(String authorSurname) throws  WrongDataException {
        if (authorSurname != null) {
            if (StrUtils.isBlank(authorSurname)) {
                throw new WrongDataException(String.format(this.msgErrorAuthorSurname, authorSurname));
            }
        }
    }

    private void checkName(String authorName) throws WrongDataException {
        if (authorName == null) {
            throw new WrongDataException(String.format(this.msgErrorAuthorName, "<null>"));
        } else if (StrUtils.isBlank(authorName)) {
            throw new WrongDataException(String.format(this.msgErrorAuthorName, authorName));
        }
    }

    private void checkPatronymic(String authorPatronymic) throws WrongDataException {
        if (authorPatronymic != null) {
            if (StrUtils.isBlank(authorPatronymic)) {
                throw new WrongDataException(String.format(this.msgErrorAuthorPatronymic, authorPatronymic));
            }
        }
    }

    private final String msgErrorAuthorId;

    private final String msgErrorAuthorSurname;

    private final String msgErrorAuthorName;

    private final String msgErrorAuthorPatronymic;
}
