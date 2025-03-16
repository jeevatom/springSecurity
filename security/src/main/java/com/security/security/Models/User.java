package com.security.security.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "roommates")
public class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("userid")
    private int userid;
    @Column(name = "username")
    private String username;
    @Column(name = "password" )
    private String Password;

    public String getRole() {
        return (this.role == 1) ? "ADMIN" : "USER";
    }

    public void setRole(byte role) {
        this.role = role;
    }

    private byte role;
    

    public User() {
    }
    
    public User(String username, String password) {
        this.username = username;
        Password = password;
    }
}