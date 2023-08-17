package com.example.socialnet.service;

import com.example.socialnet.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public Post InsertPost(Post post, Long UserId) {
        return null;
    }

    @Override
    public Post EditPost(Long postId, Post post) {
        return null;
    }

    @Override
    public ResponseEntity<?> deletePost(Long PostId) {
        return null;
    }
}
