package persistance.exceptions;

public class ApiServerException extends Exception {
    public ApiServerException(String message) {
        super(message);
    }
    public ApiServerException() {
        super();
    }
}
