package com.recap.carrental.core.business.requests.userRequests;

import com.recap.carrental.core.entities.Role;

public record UserCreateRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role
) {}
