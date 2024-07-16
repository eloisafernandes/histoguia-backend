package com.histoguia_backend.Histoguia.model;

public class JwtResponse {
    private final String token;
    private final Long userId;
    private UserRole role;

    public JwtResponse(String token, Long userId, UserRole role) {
        this.token = token;
        this.userId = userId;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRole getRole(){
        return role;
    }
}
