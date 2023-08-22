package com.example.socialnet.repository;

import com.example.socialnet.entities.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
@RepositoryRestResource
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findPostById(Long id);
    List<Post> findPostsByUserEmail(String email);
    @Transactional
    void deletePostById (Long postId);
}