package com.recap.carrental.business.requests.userRequests;

public record UserCreateRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {}
