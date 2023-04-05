package com.example.assignmentimt.exceptions;

public class DuplicatePolicyNumber extends RuntimeException{
    public DuplicatePolicyNumber() {
    }

    public DuplicatePolicyNumber(String message) {
        super(message);
    }

    public DuplicatePolicyNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatePolicyNumber(Throwable cause) {
        super(cause);
    }

    public DuplicatePolicyNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
