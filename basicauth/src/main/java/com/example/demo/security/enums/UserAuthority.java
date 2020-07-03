package com.example.demo.security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserAuthority {

    USER_READ("com.example.demo.user:read"),
    USER_WRITE("com.example.demo.user:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    @Getter
    private final String value;
}
