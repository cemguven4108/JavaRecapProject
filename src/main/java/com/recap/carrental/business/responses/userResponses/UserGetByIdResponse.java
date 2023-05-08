package com.recap.carrental.business.responses.userResponses;

public record UserGetByIdResponse(
        int id,
        String firstName,
        String lastName,
        String email,
        String password
) {}
