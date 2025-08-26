package com.notes.app.noteapp.repository;

import com.notes.app.noteapp.entities.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesJpaRepository extends JpaRepository<NotesEntity, Integer> {
    List<NotesEntity> findByUserId(int userId);
    NotesEntity findById(int id);
}
