package com.example.socialnet.service;

import com.example.socialnet.entities.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post, Long userId);
    Post editPost(Post post);
    void deletePost(Long postId);
    Post getPostById(Long id);
    List<Post> getAllUserPosts(String email);
    List<Post> getAllPosts();
}
