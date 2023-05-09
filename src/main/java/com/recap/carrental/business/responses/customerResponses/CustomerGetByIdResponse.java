package com.recap.carrental.business.responses.customerResponses;

public record CustomerGetByIdResponse(
        int id,
        String companyName,
        String firstName,
        String lastName,
        String email,
        String password
) {}
