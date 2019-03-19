package yaklyushkin.spring_2019_02.hw04.service.impl;

import yaklyushkin.spring_2019_02.hw04.consts.Consts;
import yaklyushkin.spring_2019_02.hw04.domain.Person;
import yaklyushkin.spring_2019_02.hw04.service.MessageService;
import yaklyushkin.spring_2019_02.hw04.service.PersonProvider;

import java.util.Locale;
import java.util.Scanner;

public class ConsolePersonProvider implements PersonProvider {

    public ConsolePersonProvider(String language, MessageService messageSource) {
        Locale locale = Consts.getLocale(language);
        this.msgSurname = messageSource.getMessage(
                Consts.MSG_PERSON_READER_SURNAME, null, locale);
        this.msgName = messageSource.getMessage(
                Consts.MSG_PERSON_READER_NAME, null, locale);
    }

    @Override
    public Person get() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.msgSurname);
        String surname = scanner.nextLine();
        System.out.println(this.msgName);
        String name = scanner.nextLine();

        return new Person(surname, name);
    }

    private final String msgSurname;
    private final String msgName;
}
