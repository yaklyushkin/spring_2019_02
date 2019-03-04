package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.domain.Person;
import yaklyushkin.spring_2019_02.hw01.service.IPersonProvider;

import java.util.Scanner;

public class ConsolePersonProvider implements IPersonProvider {

    @Override
    public Person get() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        return new Person(surname, name);
    }
}
