package com.notes.app.noteapp.repository;

import com.notes.app.noteapp.entities.NotesEntity;
import com.notes.app.noteapp.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotesJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static String USER_INSERT_QUERY= """
            insert into Users(id,name,username,password)
            values(?,?,?,?);
            """;

    static String NOTES_INSERT_QUERY= """
            insert into NOtes(id,userid,title,description)
            values(?,?,?,?);
            """;

    public void insertUserAtInit(UserEntity userEntity){
        jdbcTemplate.update(USER_INSERT_QUERY, userEntity.getId(),userEntity.getName(),userEntity.getUserName(),userEntity.getPassword());
    }

    public void insertNotesAtInit(NotesEntity notesEntity){
        jdbcTemplate.update(NOTES_INSERT_QUERY,notesEntity.getId(), notesEntity.getUserId(),notesEntity.getTitle(),notesEntity.getDescription());
    }
}
