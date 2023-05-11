package com.recap.carrental.core.utilities.exceptions.runtimeExceptions;

public class EntityDoesNotExistException extends RuntimeException{
    public EntityDoesNotExistException(String message) {
        super(message);
    }

    public EntityDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
