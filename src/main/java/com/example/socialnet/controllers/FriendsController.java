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
import java.util.NoSuchElementException;

//TODO: FriendsController logic

@RestController
@AllArgsConstructor
@RequestMapping("/friends")
@PreAuthorize("isAuthenticated()")
public class FriendsController {

    private final FriendshipServiceImpl friendshipService;
    private final UserServiceImpl userService;
    private final FollowershipServiceImpl followershipService;

    @PostMapping("/add/{friend_id}")
    public ResponseEntity<?> sendFriendRequest(Principal principal, @PathVariable @RequestParam Long friend_id) {
        User currentUser = userService.getUser(principal.getName());
        if(friendshipService.getByUsers(currentUser.getId(), friend_id).isPresent()) {
            Friendship friendship = new Friendship(userService.getUser(currentUser.getId()), userService.getUser(friend_id));
            friendshipService.save(friendship);
        } else {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //TODO: add credentials validation

    @PutMapping("/accept/{friendship_id}")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<?> acceptFriendRequest(@PathVariable Long friendship_id) {
        Friendship friendship = friendshipService.findById(friendship_id);
        if (friendship != null && friendship.isFriends()) {
            friendshipService.acceptFriendship(friendship);
        } else {
            throw new NoSuchElementException();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/get_all")
    public List<Friendship> getAllFriendship() {
        return friendshipService.toList();
    }

}
