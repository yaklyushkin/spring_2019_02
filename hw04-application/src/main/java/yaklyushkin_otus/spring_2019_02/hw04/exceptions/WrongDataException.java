package yaklyushkin_otus.spring_2019_02.hw04.exceptions;

public class WrongDataException extends Exception {

    public WrongDataException(String message)
    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private String message;
}
