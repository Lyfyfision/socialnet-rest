package com.example.socialnet.service.impl;

import com.example.socialnet.entities.User;
import com.example.socialnet.repository.UserRepository;
import com.example.socialnet.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = repo.findById(id);
        return unwrapUser(user);
    }

    @Override
    public Optional<User> getUser(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return repo.findAll();
    }

    @Override
    public User insertUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public boolean alreadyRegistered(String email) {
        return repo.existsByEmail(email);
    }

    static User unwrapUser(Optional<User> entity) {
        if (entity.isPresent()) return entity.get();
        else throw new RuntimeException();
    }
}
