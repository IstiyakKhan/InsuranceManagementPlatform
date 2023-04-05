package com.example.assignmentimt.exceptions;

public class ClaimNumDuplicate extends RuntimeException{
    public ClaimNumDuplicate() {
    }

    public ClaimNumDuplicate(String message) {
        super(message);
    }

    public ClaimNumDuplicate(String message, Throwable cause) {
        super(message, cause);
    }

    public ClaimNumDuplicate(Throwable cause) {
        super(cause);
    }

    public ClaimNumDuplicate(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
