package com.recap.carrental.business.requests.carRequests;

import com.recap.carrental.entities.enums.State;

public record CarUpdateRequest(
        int id,
        String plateNumber,
        int dailyPrice,
        State state,
        String description,
        int model_id,
        int color_id
){}
