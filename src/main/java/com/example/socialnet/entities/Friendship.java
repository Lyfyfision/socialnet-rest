package com.example.socialnet.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

//TODO: is serialization needed?

@Entity
@Table(name = "friendships")
@NoArgsConstructor
@Getter
@Setter
public class Friendship implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

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
    private boolean isFriends;

    @PrePersist
    public void setUpStatus() {
        this.isFriends = false;
    }

    public Friendship(User userSender, User userReceiver) {
        this.userSender = userSender;
        this.userReceiver = userReceiver;
    }
}
