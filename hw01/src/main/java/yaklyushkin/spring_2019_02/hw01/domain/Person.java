package yaklyushkin.spring_2019_02.hw01.domain;

public class Person {

    public Person(String surname, String name) {
        this._surname = surname;
        this._name = name;
    }

    public String get_surname() {
        return _surname;
    }

    public String get_name() {
        return _name;
    }

    private final String _surname;

    private final String _name;
}
