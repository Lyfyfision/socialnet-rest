package com.example.socialnet.service;

import com.example.socialnet.model.User;
import com.example.socialnet.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public String insertUser(User user) {
        return null;
    }

    @Override
    public String fetchUserToken(String user) {
        return null;
    }

    @Override
    public boolean alreadyRegistered(String email) {
        return false;
    }
}
