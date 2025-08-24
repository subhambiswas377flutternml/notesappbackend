package com.notes.app.noteapp.model.request;

public class SignupRequest {
    private String name;
    private String userName;
    private String password;

    public SignupRequest(){}
    public SignupRequest(String name, String userName, String password){
        this.name=name;
        this.userName=userName;
        this.password=password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
