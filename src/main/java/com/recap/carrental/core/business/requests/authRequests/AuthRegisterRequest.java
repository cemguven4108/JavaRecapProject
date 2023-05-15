package com.recap.carrental.core.business.requests.authRequests;

import com.recap.carrental.core.entities.enums.Role;

public record AuthRegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        Role role
) {}
