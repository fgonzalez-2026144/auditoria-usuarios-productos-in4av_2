/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.model;

/**
 *
 * @author informatica
 */
public class User {

    private String idUser;
    private String name;
    private String lastname;
    private String email;
    private String user;
    private String password;

    public User() {

    }

    public User(String idUser, String name, String lastname, String email, String user, String password) {
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.user = user;
        this.password = password;
    }

    public User(String password, String name, String lastname, String email, String user) {
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.user = user;
    }

    public String getId_user() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
