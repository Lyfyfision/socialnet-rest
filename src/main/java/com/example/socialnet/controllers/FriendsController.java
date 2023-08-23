package com.example.socialnet.controllers;

import com.example.socialnet.entities.Friendship;
import com.example.socialnet.entities.User;
import com.example.socialnet.service.impl.FollowershipServiceImpl;
import com.example.socialnet.service.impl.FriendshipServiceImpl;
import com.example.socialnet.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

//TODO: FriendsController logic

@RestController
@AllArgsConstructor
@RequestMapping("{user_id}/friends")
@PreAuthorize("isAuthenticated()")
public class FriendsController {

    private final FriendshipServiceImpl friendshipService;
    private final UserServiceImpl userService;
    private final FollowershipServiceImpl followershipService;

    @PostMapping("/add/{friend_id}")
    public ResponseEntity<?> sendFriendRequest(@PathVariable Long user_id, @PathVariable Long friend_id) {
        if(friendshipService.getByUsers(user_id, friend_id).isPresent()) {
            Friendship friendship = new Friendship(userService.getUser(user_id), userService.getUser(friend_id));
            friendshipService.save(friendship);
        } else {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/accept_{friend_id}/{friendship_id}")
    public ResponseEntity<?> acceptFriendRequest(@PathVariable Long user_id,
                                                 @PathVariable Long friendship_id, @PathVariable Long friend_id) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public List<Friendship> getAllFriendship(@PathVariable Long user_id) {
        return null;
    }

}
