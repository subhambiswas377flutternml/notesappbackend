package com.notes.app.noteapp.model.response;

import com.notes.app.noteapp.entities.UserEntity;

public class AuthResponse {
    private int status;
    private String message;
    private UserEntity userEntity;

    public AuthResponse(){}
    public AuthResponse(int status, String message, UserEntity userEntity){
        this.message=message;
        this.status=status;
        this.userEntity=userEntity;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
