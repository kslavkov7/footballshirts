package com.example.shirts.model.service;

public class UserRegisterServiceModel {
    private String username;
    private String fullName;
    private String password;
    private String email;

    public UserRegisterServiceModel(String email) {
        this.email = email;
    }

    public UserRegisterServiceModel() {
    }

    public String getUsername() {
        return username != null ?
                username.trim() :
                null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
