package com.recap.carrental.core.business.requests.authRequests;

public record AuthRegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password
) {}
