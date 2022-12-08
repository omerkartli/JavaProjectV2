package com.example.javaprojectv2.model;


import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) ///Auto olabilir bu
    @Column(name= "id")
    private Long id;

    @Column(name= "first_name")
    private String name;
    @Column(name= "last_name")
    private String surname;
    @Column(name= "user_name")
    private String username;
    @Column(name= "password")
    private String userpassword;
    @Column(name= "role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }




}
