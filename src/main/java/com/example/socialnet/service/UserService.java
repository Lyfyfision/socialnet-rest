package com.example.socialnet.service;

import com.example.socialnet.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User insertUser(User user);
    boolean alreadyRegistered(String email);
    User getUser(Long id) throws Exception;
    Optional<User> getUser(String username) throws Exception;
    List<User> getUsers();
}
