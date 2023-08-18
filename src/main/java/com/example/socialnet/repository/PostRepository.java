package com.example.socialnet.repository;

import com.example.socialnet.entities.Post;
import com.example.socialnet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
@RepositoryRestResource
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findById(Long id);
    Optional<Post> findPostByUser(User user);
    List<Post> findPostsByUser (User user);
    void createPost (Post post);
    void updatePost (Long id, Post post);
    void deletePostById (Long id);

}