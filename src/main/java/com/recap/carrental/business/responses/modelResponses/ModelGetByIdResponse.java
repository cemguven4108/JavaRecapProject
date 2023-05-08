package com.recap.carrental.business.responses.modelResponses;

public record ModelGetByIdResponse(
        int id,
        String brandName,
        String modelName,
        int modelYear
){}
