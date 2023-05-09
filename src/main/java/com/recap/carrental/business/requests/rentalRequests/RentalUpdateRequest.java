package com.recap.carrental.business.requests.rentalRequests;

import java.util.Date;

public record RentalUpdateRequest(
        Date rentDate,
        int carId,
        int customerId
) {}
