package com.notes.app.noteapp.repository;

import com.notes.app.noteapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
}
