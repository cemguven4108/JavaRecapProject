package com.recap.carrental.core.utilities.exceptions;

import java.time.ZonedDateTime;

public record ExceptionDetails(
        String message,
        ZonedDateTime timestamp
) {}
