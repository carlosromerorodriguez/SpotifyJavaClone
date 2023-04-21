package persistance.exceptions;

public class ConfigFileNotFoundException extends Exception {
    public ConfigFileNotFoundException(String message) {
        super(message);
    }
    public ConfigFileNotFoundException() {
        super();
    }
}
