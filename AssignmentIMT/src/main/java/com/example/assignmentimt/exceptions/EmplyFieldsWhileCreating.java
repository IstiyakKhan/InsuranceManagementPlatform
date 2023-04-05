package com.example.assignmentimt.exceptions;

public class EmplyFieldsWhileCreating extends RuntimeException{

    public EmplyFieldsWhileCreating() {
    }

    public EmplyFieldsWhileCreating(String message) {
        super(message);
    }

    public EmplyFieldsWhileCreating(String message, Throwable cause) {
        super(message, cause);
    }

    public EmplyFieldsWhileCreating(Throwable cause) {
        super(cause);
    }

    public EmplyFieldsWhileCreating(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
