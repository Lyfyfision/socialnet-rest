package com.example.socialnet.service;

import com.example.socialnet.entities.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {

    Post InsertPost(Post post, Long UserId);

    Post EditPost(Long postId,Post post);

    ResponseEntity<?> deletePost(Long PostId);
}
