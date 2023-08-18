package com.example.socialnet.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long id) {
        super("Post with ID: " + id + " not found :(");
    }
}
