package com.example.socialnet.dto;

import com.example.socialnet.entities.Post;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.example.socialnet.entities.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String username;
    private final List<Post> posts;
}