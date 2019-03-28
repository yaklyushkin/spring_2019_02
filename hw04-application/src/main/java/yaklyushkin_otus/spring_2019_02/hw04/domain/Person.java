package yaklyushkin_otus.spring_2019_02.hw04.domain;

public class Person {

    public Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    private final String surname;

    private final String name;
}
