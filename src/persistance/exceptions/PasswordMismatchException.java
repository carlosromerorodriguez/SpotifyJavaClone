package persistance.exceptions;

public class PasswordMismatchException extends Exception {
    public PasswordMismatchException(String message) {
        super(message);
    }
    public PasswordMismatchException() {
        super();
    }
}
