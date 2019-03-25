package yaklyushkin_otus.spring_2019_02.hw04.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import yaklyushkin_otus.spring_2019_02.hw04.consts.Consts;
import yaklyushkin_otus.spring_2019_02.hw04.service.impl.DefaultMessageServie;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class MessageServiceTest {

    @Test
    public void messageServiceTest() {
        DefaultMessageServie messageServie = new DefaultMessageServie(Consts.LANGUAGE_RUSSIAN);
        String message = messageServie.getMessage("quiz.service.question", null, RUSSIANL_LOCALE);
        assertEquals("Вопрос № %d: '%s'", message);
    }

    private static Locale RUSSIANL_LOCALE = new Locale("ru", "RU");
}
