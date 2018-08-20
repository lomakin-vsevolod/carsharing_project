package com.by.lomakin.carsharing.web.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public final class AuthHelper {

    private AuthHelper() {
    }

    public static Integer getLoggedUserId() {
        final SecurityContext context = SecurityContextHolder.getContext();
        final ExtendedUsernamePasswordAuthenticationToken authentication = (ExtendedUsernamePasswordAuthenticationToken) context
                .getAuthentication();
        return authentication.getId();
    }
}
