package com.example.socialnet.service.impl;

import com.example.socialnet.entities.Friendship;
import com.example.socialnet.entities.User;
import com.example.socialnet.repository.FriendshipRepository;
import com.example.socialnet.service.FriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FriendshipServiceImpl implements FriendshipService {

    private final FriendshipRepository friendsRepo;

    @Override
    @Transactional
    public Friendship save(Friendship entity) {
        return friendsRepo.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Friendship> toList() {
        return friendsRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Friendship> getByUsers(Long userSenderId, Long userReceiverId) {
        return friendsRepo.findByUserSenderIdAndUserReceiverId(userSenderId, userReceiverId);
    }
    @Override
    @Transactional(readOnly = true)
    public Friendship findById(Long id) {
        return friendsRepo.findById(id).orElse(null);
    }
}
