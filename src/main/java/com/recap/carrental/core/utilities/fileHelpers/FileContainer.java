package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.http.MediaType;

public record FileContainer(
        MediaType contentType,
        byte[] imageData
) {}
