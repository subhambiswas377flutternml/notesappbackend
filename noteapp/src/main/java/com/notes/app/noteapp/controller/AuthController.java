package com.notes.app.noteapp.controller;

import com.notes.app.noteapp.entities.UserEntity;
import com.notes.app.noteapp.model.request.auth.LoginRequest;
import com.notes.app.noteapp.model.request.auth.SignupRequest;
import com.notes.app.noteapp.model.response.AuthResponse;
import com.notes.app.noteapp.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "app/auth", consumes = "application/json", produces = "application/json")
public class AuthController {
    @Autowired
    UserJpaRepository userJpaRepository;

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest signupRequest){
        try{
            if(signupRequest.getPassword().length()>10||signupRequest.getPassword().length()<8){
                return ResponseEntity.status(201).body(new AuthResponse(201, "Password must be least 8 and at max 10 chars long",null));
            }

            List<UserEntity> users = userJpaRepository.findAll();
            for(int i=0;i<users.size();i++){
                if(Objects.equals(users.get(i).getUserName(), signupRequest.getUserName())){
                    return ResponseEntity.status(201).body(new AuthResponse(201, "User already exists",null));
                }
            }

            int tempUserId = 0;
            if(users.isEmpty()){
                tempUserId=1;
            }else{
                tempUserId=users.getLast().getId()+1;
            }
            UserEntity newUser = new UserEntity(tempUserId, signupRequest.getName(), signupRequest.getUserName(), signupRequest.getPassword());
            userJpaRepository.save(newUser);
            return ResponseEntity.ok(new AuthResponse(200,"Success",newUser));

        }catch(Exception ex){
            return ResponseEntity.status(500).body(new AuthResponse(500,"Internal Error",null));
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        try{
            List<UserEntity> users = userJpaRepository.findAll();
            for(int i=0;i<users.size();i++) {
                if(Objects.equals(users.get(i).getUserName(), loginRequest.getUserName())){
                    if(Objects.equals(users.get(i).getPassword(), loginRequest.getPassword())){
                        return ResponseEntity.ok(new AuthResponse(200, "Success", users.get(i)));

                    }else{
                        return ResponseEntity.status(201).body(new AuthResponse(201, "Incorrect username or password",null));
                    }
                }
            }

            return ResponseEntity.status(404).body(new AuthResponse(404, "User doesn't exist", null));
        }catch(Exception ex){
            return ResponseEntity.status(500).body(new AuthResponse(500,"Internal Error",null));
        }
    }
}
