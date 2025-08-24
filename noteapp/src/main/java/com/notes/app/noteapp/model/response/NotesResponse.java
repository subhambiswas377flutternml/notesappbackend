package com.notes.app.noteapp.model.response;

import com.notes.app.noteapp.entities.NotesEntity;

import java.util.List;

public class NotesResponse {
    private int status;
    private String message;
    private List<NotesEntity> notes;

    public NotesResponse(){}
    public NotesResponse(int status, String message, List<NotesEntity> notes){
        this.message=message;
        this.status=status;
        this.notes=notes;
    }

    public String getMessage() {
        return message;
    }

    public List<NotesEntity> getNotes() {
        return notes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNotes(List<NotesEntity> notes) {
        this.notes = notes;
    }
}
