package com.example.socialnet.service.impl;

import com.example.socialnet.entities.Post;
import com.example.socialnet.entities.User;
import com.example.socialnet.exceptions.PostNotFoundException;
import com.example.socialnet.exceptions.UserNotFoundException;
import com.example.socialnet.repository.PostRepository;
import com.example.socialnet.repository.UserRepository;
import com.example.socialnet.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post editPost(Post post) {
        return postRepository.findById(post.getId()).map(updatedPost -> {
            updatedPost.setTitle(post.getTitle());
            updatedPost.setContent(post.getContent());
            return postRepository.save(updatedPost);
        }).orElseThrow(() -> new PostNotFoundException(post.getId()));
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deletePostById(postId);
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findPostById(id);
        return unwrapPost(post, id);
    }

    @Override
    public List<Post> getAllUserPosts(String email) {
        return postRepository.findPostsByUserEmail(email);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    static Post unwrapPost(Optional<Post> entity, Long postId) {
        if(entity.isPresent()) return entity.get();
        else throw new PostNotFoundException(postId);
    }
}
