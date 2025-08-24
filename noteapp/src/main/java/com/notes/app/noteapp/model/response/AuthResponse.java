package com.notes.app.noteapp.model.response;

import com.notes.app.noteapp.entities.UserEntity;

public class AuthResponse {
    private int status;
    private String message;
    private UserEntity user;

    public AuthResponse(){}
    public AuthResponse(int status, String message, UserEntity user){
        this.message=message;
        this.status=status;
        this.user=user;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
