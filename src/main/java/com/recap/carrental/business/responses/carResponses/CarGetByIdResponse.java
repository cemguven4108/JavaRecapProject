package com.recap.carrental.business.responses.carResponses;

import com.recap.carrental.entities.enums.State;

public record CarGetByIdResponse(
        int id,
        String plateNumber,
        String brandName,
        String modelName,
        int modelYear,
        String colorName,
        int dailyPrice,
        State state,
        String description
) {}
