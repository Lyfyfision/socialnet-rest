package com.example.socialnet.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "friendships")
@Data
public class Friendship implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship_id", nullable = false)
    private Long friendshipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_sender_id", nullable = false)
    private User userSender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_receiver_id", nullable = false)
    private User userReceiver;

    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private boolean isFriend;

    @PrePersist
    public void setUpStatus() {
        this.isFriend = false;
    }
}
