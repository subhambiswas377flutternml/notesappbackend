package com.notes.app.noteapp.model.request.notes;

public class AddNotesRequest {
    private int userId;
    private String title;
    private String description;

    public AddNotesRequest(){}
    public AddNotesRequest(int userId, String title, String description){
        this.description=description;
        this.title=title;
        this.userId=userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
    }
}
