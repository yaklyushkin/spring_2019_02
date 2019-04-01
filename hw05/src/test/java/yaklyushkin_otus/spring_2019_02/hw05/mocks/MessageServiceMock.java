package yaklyushkin_otus.spring_2019_02.hw05.mocks;

import yaklyushkin_otus.spring_2019_02.hw05.consts.ErrorConsts;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;

import java.util.Locale;

public class MessageServiceMock implements MessageService {

    @Override
    public String getMessage(String code, Object[] args, Locale locale) {
        String result = null;
        if (locale.getLanguage().equals("ru")) {
            if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_GENRE_ID)) {
                result = "Ошибка в данных: genreId='%d'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_GENRE_NAME)) {
                result = "Ошибка в данных: genreName='%s'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_ID)) {
                result = "Ошибка в данных: authorId='%d'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_SURNAME)) {
                result = "Ошибка в данных: authorSurname='%s'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_NAME)) {
                result = "Ошибка в данных: authorName='%s'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_AUTHOR_PATRONYMIC)) {
                result = "Ошибка в данных: authorPatronymic='%s'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_BOOK_ID)) {
                result = "Ошибка в данных: bookId='%d'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_BOOK_TITLE)) {
                result = "Ошибка в данных: bookTitle='%s'";
            }
        } else if (locale.getLanguage().equals("en")) {
            if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_GENRE_ID)) {
                result = "Wrong data: genreId='%d'";
            } else if (code.equals(ErrorConsts.ERRMSG_WRONGDATA_GENRE_NAME)) {
                result = "Wrong data: genreName='%s'";
            }
        }
        return result;
    }
}
