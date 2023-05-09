package com.recap.carrental.business.responses.rentalResponses;

import java.util.Date;

public record RentalGetByIdResponse(
        int id,
        Date rentDate,
        Date returnDate,
        int carId,
        String firstName,
        String lastName
) {}
