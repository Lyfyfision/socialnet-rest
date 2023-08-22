package com.example.socialnet.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Credentials implements GrantedAuthority {
    ROLE_ADMIN, ROLE_USER;
    public String getAuthority() {
        return name();
    }
}
