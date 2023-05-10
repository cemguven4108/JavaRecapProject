package com.recap.carrental.business.requests.carImageRequests;

import java.time.ZonedDateTime;

public record CarImageCreateRequest(
        int carId,
        String imagePath,
        ZonedDateTime timestamp
) {}
