package com.example.socialnet.service;

import com.example.socialnet.model.User;

public interface UserService {

    String insertUser(User user);
    String fetchUserToken(String user);
    boolean alreadyRegistered(String email);
}
