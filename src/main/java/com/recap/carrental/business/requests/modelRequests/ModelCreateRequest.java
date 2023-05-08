package com.recap.carrental.business.requests.modelRequests;

public record ModelCreateRequest(
        String modelName,
        int modelYear,
        int brandId
){}
