package com.example.socialnet.service;

import com.example.socialnet.entities.User;
import com.example.socialnet.repository.UserRepository;
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
    public User getUser(Long id) throws Exception {
        Optional<User> user = repo.findById(id);
        return unwrapUser(user);
    }

    @Override
    public List<User> getUsers() throws Exception {
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
    static User unwrapUser(Optional<User> entity) throws Exception {
        if (entity.isPresent()) return entity.get();
        else throw new Exception("User not found");
    }
}
