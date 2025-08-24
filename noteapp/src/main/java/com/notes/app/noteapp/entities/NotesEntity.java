package com.notes.app.noteapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Notes")
public class NotesEntity {
    @Id
    private int id;
    @Column(name = "userid")
    private int userId;
    @Column
    private String title;
    @Column
    private String description;

    public NotesEntity(){}
    public NotesEntity(int id,int userId, String title, String description){
        this.description=description;
        this.id=id;
        this.title=title;
        this.userId=userId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
