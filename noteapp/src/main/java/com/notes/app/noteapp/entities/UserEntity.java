package com.notes.app.noteapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Users")
public class UserEntity {
    @Id
    private int id;
    @Column
    private String name;
    @Column(name = "username")
    private String userName;
    @Column
    private String password;

    public  UserEntity(){}
    public UserEntity(int id, String name, String userName, String password){
        this.id=id;
        this.userName=userName;
        this.name=name;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
