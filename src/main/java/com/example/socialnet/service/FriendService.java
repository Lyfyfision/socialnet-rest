package com.example.socialnet.service;

import com.example.socialnet.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface FriendService {
    /**
     * Sending a friend request to a user2 from user1, put them on the friends table
     *
     * @param sender_email    the email of user1
     * @param recipient_email the email of user2
     */
    void sendRequest(String sender_email, String recipient_email);

    /**
     * Make user2 become the friend of user1
     *
     * @param id       id of user1
     * @param username id of user2
     */
    void becomeFriend(int id, String username);

    /**
     * Get a list of all the friends of a user
     *
     * @param userId the user id
     * @return all the friends of the user
     */
    List<User> getAllFriends(Long userId);
}
