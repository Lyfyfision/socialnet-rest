package com.example.socialnet.service.impl;

import com.example.socialnet.entities.User;
import com.example.socialnet.exceptions.EntityNotFoundException;
import com.example.socialnet.repository.UserRepository;
import com.example.socialnet.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = repo.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User getUser(String username) {
        Optional<User> user = repo.findByUsername(username);
        return unwrapUser(user, 404L);
    }

    @Override
    public List<User> getUsers() {
        return repo.findAll();
    }

    @Override
    public User insertUser(User user) {
        return repo.save(user);
    }

    @Override
    public boolean alreadyRegistered(String email) {
        return repo.existsByEmail(email);
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }
}
