package yaklyushkin.spring_2019_02.hw01.exceptions;

public class WrongDataException extends Exception {

    public WrongDataException(String message)
    {
        this._message = message;
    }

    public String getMessage() {
        return _message;
    }

    private String _message;
}
