package exceptions;

public class WrongChoiceException extends RuntimeException {
    public WrongChoiceException(String message) {
        super(message);
    }
}
