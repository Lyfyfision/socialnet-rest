package com.example.socialnet.exceptions;

//TODO: add exc. logic

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("User with ID: " + userId + " not found");
    }
}
