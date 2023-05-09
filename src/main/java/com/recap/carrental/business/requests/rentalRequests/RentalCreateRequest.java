package com.recap.carrental.business.requests.rentalRequests;

import java.util.Date;

public record RentalCreateRequest(
        Date rentDate,
        int carId,
        int customerId
) {}
