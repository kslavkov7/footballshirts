package com.example.shirts.model.service;

public class UserRegisterServiceModel {
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phoneNumber;
    private String deliveryAddress;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
