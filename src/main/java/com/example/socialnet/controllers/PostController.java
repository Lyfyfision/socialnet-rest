package com.example.socialnet.controllers;

import com.example.socialnet.service.impl.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO: posts logic

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostServiceImpl postService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost() {
        return null;
    }
    @PutMapping("/edit/{post_id}")
    public ResponseEntity<?> updatePost(@PathVariable Long post_id) {
        return null;
    }
    @GetMapping("/{user_email}")
    public ResponseEntity<?> getUserPosts(@PathVariable String user_email) {
        return null;
    }
    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        return null;
    }
}
