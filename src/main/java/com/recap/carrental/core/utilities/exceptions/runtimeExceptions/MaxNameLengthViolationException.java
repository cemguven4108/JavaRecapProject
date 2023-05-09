package com.recap.carrental.core.utilities.exceptions.runtimeExceptions;

public class MaxNameLengthViolationException extends RuntimeException {
    public MaxNameLengthViolationException(String message) {
        super(message);
    }

    public MaxNameLengthViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
