package com.example.assignmentimt.exceptions;

public class InvalidPolicyNumber extends RuntimeException{

    public InvalidPolicyNumber() {
    }

    public InvalidPolicyNumber(String message) {
        super(message);
    }

    public InvalidPolicyNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPolicyNumber(Throwable cause) {
        super(cause);
    }

    public InvalidPolicyNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
