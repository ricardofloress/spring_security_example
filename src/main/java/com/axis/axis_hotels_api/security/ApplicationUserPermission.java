package com.axis.axis_hotels_api.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {
    PERMISSION_READ("permission:read"),
    PERMISSION_WRITE("permission:write");

    private final String permission;
}
