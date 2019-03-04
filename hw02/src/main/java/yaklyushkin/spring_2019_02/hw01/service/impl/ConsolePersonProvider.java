package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.consts.Consts;
import yaklyushkin.spring_2019_02.hw01.domain.Person;
import yaklyushkin.spring_2019_02.hw01.service.PersonProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.Locale;
import java.util.Scanner;

@Service
public class ConsolePersonProvider implements PersonProvider {

    @Override
    public Person get() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.msgSurname);
        String surname = scanner.nextLine();
        System.out.println(this.msgName);
        String name = scanner.nextLine();

        return new Person(surname, name);
    }

    @PostConstruct
    public void init() {
        Locale locale = Consts.getLocale(this.language);
        this.msgSurname = messageSource.getMessage(
                Consts.MSG_PERSON_READER_SURNAME, null, locale);
        this.msgName = messageSource.getMessage(
                Consts.MSG_PERSON_READER_NAME, null, locale);
    }

    @Value("${common.language}")
    private String language;

    @Autowired
    private MessageSource messageSource;

    private String msgSurname;
    private String msgName;
}
