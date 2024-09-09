package com.security.security.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password" )
    private String Password;

    public User() {
    }
    
    public User(String userName, String password) {
        this.userName = userName;
        Password = password;
    }
}