package com.example.socialnet.service;

import com.example.socialnet.entities.Friendship;

import java.util.List;
import java.util.Optional;

public interface FriendshipService {
    Friendship save(Friendship entity);
    List<Friendship> toList();
    Optional<Friendship> getByUsers(Long userSenderId, Long userReceiverId);
}
