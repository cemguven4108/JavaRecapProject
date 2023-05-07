package com.recap.carrental.business.requests.carRequests;

import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import com.recap.carrental.entities.enums.State;

public record CarUpdateRequest(
        String plateNumber,
        int dailyPrice,
        State state,
        String description,
        ModelGetByIdResponse model,
        ColorGetByIdResponse color
){}
