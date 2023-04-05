package com.example.assignmentimt.exceptions;

public class InvalidContactNumber extends RuntimeException{
    public InvalidContactNumber() {
    }

    public InvalidContactNumber(String message) {
        super(message);
    }

    public InvalidContactNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidContactNumber(Throwable cause) {
        super(cause);
    }

    public InvalidContactNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
