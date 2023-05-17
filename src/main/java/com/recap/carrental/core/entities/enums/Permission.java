package com.recap.carrental.core.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_CREATE("admin:create"),

    USER_READ("management:read"),
    USER_UPDATE("management:update"),
    USER_DELETE("management:delete"),
    USER_CREATE("management:create");

    @Getter
    private final String permission;
}
