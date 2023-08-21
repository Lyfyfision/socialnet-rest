package com.example.socialnet.controllers;

import com.example.socialnet.entities.User;
import com.example.socialnet.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO: add usController logic

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    //TODO: add email and username validation
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody String username, String email, String password) {
        userService.insertUser(new User(username, email, password));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO: add login call
    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return null;
    }
}
