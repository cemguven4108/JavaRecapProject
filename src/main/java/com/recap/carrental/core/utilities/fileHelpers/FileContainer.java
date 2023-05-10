package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.core.io.InputStreamResource;

public record FileContainer(
        String contentType,
        String headerValue,
        InputStreamResource resource
) {}
