package com.recap.carrental.business.requests.carImageRequests;

import java.time.ZonedDateTime;

public record CarImageCreateRequest(
        String filePath,
        ZonedDateTime timestamp
) {}
