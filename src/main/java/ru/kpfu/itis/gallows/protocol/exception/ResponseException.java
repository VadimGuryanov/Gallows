package ru.kpfu.itis.gallows.protocol.exception;

public class ResponseException extends Throwable {

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseException(Throwable cause) {
        super(cause);
    }
}
