package yaklyushkin_otus.spring_2019_02.hw05.exceptions;

public class WrongDataException extends Exception {

    public WrongDataException(String message)
    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;
}
