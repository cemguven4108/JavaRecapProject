package com.recap.carrental.core.business.responses.userResponses;

import com.recap.carrental.core.entities.Role;

public record UserGetByEmailResponse(
        int id,
        String firstName,
        String lastName,
        String email,
        String password,
        Role role
) {}
