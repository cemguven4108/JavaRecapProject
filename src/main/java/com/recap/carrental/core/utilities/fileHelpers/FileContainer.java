package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.core.io.Resource;


public record FileContainer(
        String contentType,
        String headerValue,
        Resource resource
) {}
