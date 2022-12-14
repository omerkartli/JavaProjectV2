package com.example.javaprojectv2.service.dto;

import com.sun.istack.NotNull;

public class CustomerInputDTO {


    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String username;
    @NotNull
    private String userpassword;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return userpassword;
    }

    public void setPassword(String password) {
        this.userpassword = password;
    }


    @Override
    public String toString() {
        return "CustomerInputDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
