package com.security.security.Dto;


public class AuthResponse {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    private String token;
    private String userName;
    private String roles;
    public AuthResponse(String token, String userName, String roles) {
        this.token = token;
        this.userName = userName;
        this.roles = roles;
    }


}
