package yaklyushkin_otus.spring_2019_02.hw05_app.service.impl;

import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

public class SpringMessageSource implements MessageService {

    public SpringMessageSource() {
        this.messageSource = new ReloadableResourceBundleMessageSource();
        this.messageSource.setBasename("/i18n/bundle");
        this.messageSource.setDefaultEncoding("UTF-8");
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) {
        return this.messageSource.getMessage(code, args, locale);
    }

    private final ReloadableResourceBundleMessageSource messageSource;
}
