package com.example.socialnet.service;

import com.example.socialnet.entities.Post;
import com.example.socialnet.entities.User;
import com.example.socialnet.exceptions.PostNotFoundException;
import com.example.socialnet.exceptions.UserNotFoundException;
import com.example.socialnet.repository.PostRepository;
import com.example.socialnet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post CreatePost(Post post, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            post.setUser(user.get());
        } else {
            throw new UserNotFoundException(userId);
        }
        return postRepository.save(post);
    }

    @Override
    public Post EditPost(Post post) {
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
}
