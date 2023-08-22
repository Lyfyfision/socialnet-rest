package com.example.socialnet.service;

import com.example.socialnet.entities.Post;
import com.example.socialnet.entities.User;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post createPost(Post post, Long userId);
    Post editPost(Post post);
    void deletePost(Long postId);
    Post getPostById(Long id);
    List<Post> getAllUserPosts(String email);
    List<Post> getAllPosts();
}
