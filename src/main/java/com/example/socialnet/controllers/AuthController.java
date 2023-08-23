package com.example.socialnet.controllers;

import com.example.socialnet.entities.User;
import com.example.socialnet.security.manager.CustomAuthenticationManager;
import com.example.socialnet.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pojo.AuthRequest;

@RestController
@AllArgsConstructor
public class AuthController {
    private final UserServiceImpl userService;
    private final CustomAuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        userService.insertUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO: examine login call (error after unwrap User)

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest authRequest) {
            UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(), authRequest.getPassword());
            Authentication auth = authenticationManager.authenticate(creds);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

