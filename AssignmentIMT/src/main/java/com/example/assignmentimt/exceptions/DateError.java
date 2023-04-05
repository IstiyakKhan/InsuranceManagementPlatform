package com.example.assignmentimt.exceptions;

public class DateError extends RuntimeException{
    public DateError() {
    }

    public DateError(String message) {
        super(message);
    }

    public DateError(String message, Throwable cause) {
        super(message, cause);
    }

    public DateError(Throwable cause) {
        super(cause);
    }

    public DateError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
