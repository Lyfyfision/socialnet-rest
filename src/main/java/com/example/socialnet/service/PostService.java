package com.example.socialnet.service;

import com.example.socialnet.entities.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {

    Post CreatePost(Post post, Long userId);

    Post EditPost(Post post);

    void deletePost(Long postId);
}
