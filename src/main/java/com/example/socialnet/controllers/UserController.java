package com.example.socialnet.controllers;

import com.example.socialnet.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//TODO: add usController logic

@RestController
public class UserController {


    @PostMapping("/users/signup")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return null;
    }
}
