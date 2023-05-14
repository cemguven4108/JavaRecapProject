package com.recap.carrental.core.business.requests.authRequests;

public record AuthLoginRequest(
        String username,
        String password
) {}
