package yaklyushkin_otus.spring_2019_02.hw04.service;

import java.util.Locale;

public interface MessageService {

    String getMessage(String code, Object[] args, Locale locale);
}
