package com.recap.carrental.business.responses.carImageResponses;

import java.time.ZonedDateTime;

public record CarImageGetByIdResponse(
        int id,
        int carId,
        String imagePath,
        ZonedDateTime timestamp
) {}
