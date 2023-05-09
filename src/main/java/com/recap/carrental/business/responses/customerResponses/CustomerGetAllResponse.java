package com.recap.carrental.business.responses.customerResponses;

public record CustomerGetAllResponse(
        int id,
        String companyName,
        String firstName,
        String lastName,
        String email,
        String password
) {}
