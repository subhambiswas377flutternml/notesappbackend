package com.notes.app.noteapp.model.request.notes;

public class UpdateNotesRequest {
    private String title;
    private String description;

    public UpdateNotesRequest(){}
    public UpdateNotesRequest(String title, String description){
        this.description=description;
        this.title=title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
