package Exception;

public class NotFoundValueException extends NullPointerException {
    public NotFoundValueException(String message) {
        super(message);
    }
}
