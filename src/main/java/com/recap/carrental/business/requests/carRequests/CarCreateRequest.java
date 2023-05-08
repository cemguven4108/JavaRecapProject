package com.recap.carrental.business.requests.carRequests;

import com.recap.carrental.entities.enums.State;

public record CarCreateRequest(
        String plateNumber,
        int dailyPrice,
        State state,
        String description,
        int modelId,
        int colorId
){}
