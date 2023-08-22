package com.example.socialnet.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
public enum Credentials implements GrantedAuthority {
    ROLE_ADMIN, ROLE_USER;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return name();
    }
}
