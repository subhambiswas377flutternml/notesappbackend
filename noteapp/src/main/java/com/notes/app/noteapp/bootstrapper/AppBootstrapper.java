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
        notesJdbcRepository.insertNotesAtInit(new NotesEntity(3,1,"Notes3","Learn PHP"));
        notesJdbcRepository.insertNotesAtInit(new NotesEntity(4,1,"Notes4","Learn Fast API with python"));
        notesJdbcRepository.insertNotesAtInit(new NotesEntity(5,1,"Notes5","Learn Node.js"));
    }
}
