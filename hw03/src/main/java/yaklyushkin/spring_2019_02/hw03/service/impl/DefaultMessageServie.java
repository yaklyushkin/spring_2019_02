package yaklyushkin.spring_2019_02.hw03.service.impl;

import yaklyushkin.spring_2019_02.hw03.consts.Consts;
import yaklyushkin.spring_2019_02.hw03.service.MessageService;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class DefaultMessageServie implements MessageService {

    public DefaultMessageServie(String language) {
        Locale locale = Consts.getLocale(language);
        this.bundle = ResourceBundle.getBundle("i18n/bundle", locale);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) {
        String message = this.bundle.getString(code);

        message = new String(
                message.getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);

        return message;
    }

    private final ResourceBundle bundle;
}
