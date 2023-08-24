package com.example.socialnet.controllers;

import com.example.socialnet.entities.Post;
import com.example.socialnet.service.impl.PostServiceImpl;
import com.example.socialnet.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: posts logic

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        postService.createPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/edit/{post_id}")
    public ResponseEntity<?> updatePost(@PathVariable Long post_id) {
        postService.editPost(postService.getPostById(post_id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/see/{user_email}")
    public List<Post> getUserPosts(@PathVariable String user_email) {
        return postService.getAllUserPosts(user_email);
    }
    @GetMapping("/see/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
