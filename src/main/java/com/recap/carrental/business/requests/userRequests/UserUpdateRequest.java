package com.recap.carrental.business.requests.userRequests;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {}
