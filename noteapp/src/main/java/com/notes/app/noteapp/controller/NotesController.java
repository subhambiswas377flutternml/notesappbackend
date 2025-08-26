package com.notes.app.noteapp.controller;

import com.notes.app.noteapp.entities.NotesEntity;
import com.notes.app.noteapp.entities.UserEntity;
import com.notes.app.noteapp.model.request.notes.AddNotesRequest;
import com.notes.app.noteapp.model.request.notes.UpdateNotesRequest;
import com.notes.app.noteapp.model.response.NotesResponse;
import com.notes.app.noteapp.repository.NotesJpaRepository;
import com.notes.app.noteapp.repository.UserJpaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Notes")
@RequestMapping(value = "app/notes", produces = "application/json")
public class NotesController {
    @Autowired
    NotesJpaRepository notesJpaRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @RequestMapping(value = "getByUser/{userId}", method = RequestMethod.GET)
    public ResponseEntity<NotesResponse> getByUserIf(@PathVariable(value = "userId") int userId){
       try{
           UserEntity user = userJpaRepository.findById(userId);
           if(user==null){
               return ResponseEntity.status(404).body(new NotesResponse(404, "No User exists with this ID", null));
           }else{
               List<NotesEntity> notes = notesJpaRepository.findByUserId(userId);
               return ResponseEntity.status(200).body(new NotesResponse(200, "Success", notes));
           }
       }catch(Exception ex){
           return ResponseEntity.status(500).body(new NotesResponse(500, "Internal server error", null));
       }
    }

    @RequestMapping(value = "addByUser", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<NotesResponse> addNotesByUser(@RequestBody AddNotesRequest addNotesRequest){
        try{
            UserEntity user = userJpaRepository.findById(addNotesRequest.getUserId());
            if(user==null){
                return ResponseEntity.status(404).body(new NotesResponse(404, "No User exists with this ID", null));
            }else{
                List<NotesEntity> notes = notesJpaRepository.findAll();
                NotesEntity newNote = new NotesEntity(notes.getLast().getId()+1, addNotesRequest.getUserId(), addNotesRequest.getTitle(), addNotesRequest.getDescription());
                notesJpaRepository.save(newNote);

                List<NotesEntity> notesByUser = notesJpaRepository.findByUserId(addNotesRequest.getUserId());

                return ResponseEntity.ok(new NotesResponse(200, "Success",notesByUser));
            }
        }catch(Exception ex){
            return ResponseEntity.status(500).body(new NotesResponse(500, "Internal server error", null));
        }
    }

    @RequestMapping(value = "deleteById/{noteId}", method = RequestMethod.DELETE)
    public ResponseEntity<NotesResponse> deleteById(@PathVariable(value = "noteId") int noteId){
        try{
            NotesEntity note = notesJpaRepository.findById(noteId);
            if(note==null){
                return ResponseEntity.status(404).body(new NotesResponse(404, "Note ID doesn't exist", null));
            }else{
                notesJpaRepository.deleteById(noteId);
                List<NotesEntity> updatedListPostDelete = notesJpaRepository.findByUserId(note.getUserId());
                return ResponseEntity.ok(new NotesResponse(200, "Success", updatedListPostDelete));
            }
        }catch(Exception ex){
            return ResponseEntity.status(500).body(new NotesResponse(500, "Internal Error!", null));
        }
    }

    @RequestMapping(value = "updateById/{noteId}",method = RequestMethod.PATCH)
    public ResponseEntity<NotesResponse> updateById(@PathVariable(value = "noteId") int noteId, @RequestBody UpdateNotesRequest request){
        try{
            NotesEntity note = notesJpaRepository.findById(noteId);
            if(note==null){
                return ResponseEntity.status(404).body(new NotesResponse(404, "Note ID doesn't exist", null));
            }else{
                NotesEntity updatedNote = new NotesEntity(note.getId(), note.getUserId(), request.getTitle(), request.getDescription());
                notesJpaRepository.save(updatedNote);
                List<NotesEntity> notesList = notesJpaRepository.findByUserId(note.getUserId());

                return ResponseEntity.ok(new NotesResponse(200, "Success", notesList));
            }
        }catch(Exception ex){
            return ResponseEntity.status(500).body(new NotesResponse(500, "Internal Error!", null));
        }
    }
}
