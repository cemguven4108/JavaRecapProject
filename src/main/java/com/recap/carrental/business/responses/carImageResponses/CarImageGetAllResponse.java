package com.recap.carrental.business.responses.carImageResponses;

import java.time.ZonedDateTime;

public record CarImageGetAllResponse(
        int id,
        int carId,
        String image,
        ZonedDateTime timestamp
) {}
