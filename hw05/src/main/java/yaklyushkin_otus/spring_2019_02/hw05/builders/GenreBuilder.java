package yaklyushkin_otus.spring_2019_02.hw05.builders;

import yaklyushkin_otus.spring_2019_02.hw05.consts.ErrorConsts;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Genre;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;
import yaklyushkin_otus.spring_2019_02.hw05.utils.StrUtils;

import java.util.Locale;

public class GenreBuilder {

    public GenreBuilder(String language, MessageService msgService) {
        Locale locale = StrUtils.getLocale(language);
        this.msgErrorGenreId = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_GENRE_ID, null, locale);
        this.msgErrorGenreName = msgService.getMessage(
                ErrorConsts.ERRMSG_WRONGDATA_GENRE_NAME, null, locale);
    }

    public final Genre build(int genreId, String genreName) throws WrongDataException {
        this.checkId(genreId);
        this.checkName(genreName);
        return new Genre(genreId, genreName);
    }

    private void checkId(int genreId) throws WrongDataException {
        if (genreId < 0) {
            throw new WrongDataException(String.format(this.msgErrorGenreId, genreId));
        }
    }

    private void checkName(String genreName) throws WrongDataException {
        if (genreName == null) {
            throw new WrongDataException(String.format(this.msgErrorGenreName, "<null>"));
        } else if (StrUtils.isBlank(genreName)) {
            throw new WrongDataException(String.format(this.msgErrorGenreName, genreName));
        }
    }

    private final String msgErrorGenreId;

    private final String msgErrorGenreName;
}
