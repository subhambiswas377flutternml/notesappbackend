package com.notes.app.noteapp.bootstrapper;

import com.notes.app.noteapp.entities.NotesEntity;
import com.notes.app.noteapp.entities.UserEntity;
import com.notes.app.noteapp.repository.NotesJdbcRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Transactional
@ComponentScan
public class AppBootstrapper implements CommandLineRunner {
    @Autowired
    NotesJdbcRepository notesJdbcRepository;

    @Override
    public void run(String... args) throws Exception{
        notesJdbcRepository.insertUserAtInit(new UserEntity(1,"Alex","alex03","Abcd@1234"));

        notesJdbcRepository.insertNotesAtInit(new NotesEntity(1,1,"Notes1","Learn Coding"));
        notesJdbcRepository.insertNotesAtInit(new NotesEntity(2,1,"Notes2","Learn MERN"));
    }
}
