package com.example.socialnet.repository;

import com.example.socialnet.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    Optional<Friendship> findByUserSenderIdAndUserReceiverId(Long senderId, Long receiverId);

    @Transactional
    @Modifying
    @Query("update Friendship f set f.isFriends = ?1 where f.friendshipId is not null")
    void updateStatus(Long friendshipId, boolean isFriends);

}