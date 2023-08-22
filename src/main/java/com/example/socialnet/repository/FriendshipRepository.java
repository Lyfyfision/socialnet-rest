package com.example.socialnet.repository;

import com.example.socialnet.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    Optional<Friendship> findByUserSenderIdAndUserReceiverId(Long senderId, Long receiverId);
}