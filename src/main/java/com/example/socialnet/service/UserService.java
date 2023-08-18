package com.example.socialnet.service;

import com.example.socialnet.entities.User;

import java.util.List;

public interface UserService {

    User insertUser(User user);
    boolean alreadyRegistered(String email);
    User getUser(Long id) throws Exception;
    List<User> getUsers() throws Exception;
}
