package com.recap.carrental.core.utilities.exceptions;

import com.recap.carrental.core.utilities.exceptions.runtimeExceptions.DuplicateNameException;
import com.recap.carrental.core.utilities.exceptions.runtimeExceptions.MaxNameLengthViolationException;
import com.recap.carrental.core.utilities.exceptions.runtimeExceptions.MinNameLengthViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDetails businessExceptionHandler(DuplicateNameException exception) {
        return new ExceptionDetails(
                exception.getMessage(),
                ZonedDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDetails businessExceptionHandler(MinNameLengthViolationException exception) {
        return new ExceptionDetails(
                exception.getMessage(),
                ZonedDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDetails businessExceptionHandler(MaxNameLengthViolationException exception) {
        return new ExceptionDetails(
                exception.getMessage(),
                ZonedDateTime.now()
        );
    }
}
