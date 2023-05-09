package com.recap.carrental.core.utilities.exceptions.runtimeExceptions;

public class MinNameLengthViolationException extends RuntimeException {
    public MinNameLengthViolationException(String message) {
        super(message);
    }

    public MinNameLengthViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
