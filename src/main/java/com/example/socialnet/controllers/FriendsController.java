package com.example.socialnet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO: FriendsController logic

@RestController
@AllArgsConstructor
@RequestMapping("/friends")
public class FriendsController {

    @GetMapping("/list")
    public ResponseEntity<?> getMyFriends() {
        return null;
    }
    @GetMapping("/my_followers")
    public ResponseEntity<?> getMyFollowers() {
        return null;
    }
    @PostMapping("/add/{user_email}")
    public ResponseEntity<?> addFriend(@PathVariable String user_email) {
        return null;
    }
}
