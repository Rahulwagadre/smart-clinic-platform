package com.smartclinic.user.dto;

import com.smartclinic.common.security.Role;

import java.util.UUID;

public class LoginResponse {
    private UUID userId;
    private Role role;
    private String email;
    private String token;

    public LoginResponse(UUID userId, String email, Role role, String token) {
        this.userId = userId;
        this.email = email;
        this.role = role;
        this.token = token;
    }

    public void setRole(Role role) { this.role = role; }

    public Role getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setToken(String token) { this.token = token; }

    public String getToken() { return token; }
}