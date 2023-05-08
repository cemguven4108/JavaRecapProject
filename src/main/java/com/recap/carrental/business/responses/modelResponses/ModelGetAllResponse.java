package com.recap.carrental.business.responses.modelResponses;

public record ModelGetAllResponse(
        int id,
        String brandName,
        String modelName,
        int modelYear
) {}
