package com.example.javaprojectv2.service.dto;

import com.sun.istack.NotNull;

public class LoginInputDTO {


    @NotNull
    private String username;
    @NotNull
    private String userpassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "LoginInputDTO{" +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
