package com.example.socialnet.service.impl;

import com.example.socialnet.entities.Friendship;
import com.example.socialnet.entities.User;
import com.example.socialnet.repository.FriendshipRepository;
import com.example.socialnet.service.FriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FriendshipServiceImpl implements FriendshipService {

    private final FriendshipRepository friendsRepo;

    @Override
    public Friendship save(Friendship entity) {
        return friendsRepo.save(entity);
    }

    @Override
    public List<Friendship> toList() {
        return friendsRepo.findAll();
    }

    @Override
    public Optional<Friendship> getByUsers(Long userSenderId, Long userReceiverId) {
        return friendsRepo.findByUserSenderIdAndUserReceiverId(userSenderId, userReceiverId);
    }
}
