package com.github.Doomsdayrs.Jikan4java.exceptions;

public class RequestError extends Exception {
    public RequestError() {
        super();
    }

    public RequestError(String message) {
        super(message);
    }

    public RequestError(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestError(Throwable cause) {
        super(cause);
    }
}
