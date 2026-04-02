package og.example.exception;

public class UnsupportedClientException extends RuntimeException {

    public UnsupportedClientException(String message) {
        super(message);
    }
}