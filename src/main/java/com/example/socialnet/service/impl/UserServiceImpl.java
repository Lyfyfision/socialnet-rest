package com.example.socialnet.service.impl;

import com.example.socialnet.entities.User;
import com.example.socialnet.repository.UserRepository;
import com.example.socialnet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    private final BCryptPasswordEncoder encoder;


    @Override
    public User getUser(Long id) {
        Optional<User> user = repo.findById(id);
        return unwrapUser(user);
    }

    @Override
    public User getUser(String username) {
        Optional<User> user = repo.findByUsername(username);
        return unwrapUser(user);
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

    //TODO: examine unwrap method

    static User unwrapUser(Optional<User> entity) {
        if (entity.isPresent()) return entity.get();
        else throw new NoSuchElementException();
    }
}
