package com.example.socialnet.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "relationships")
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relationship_seq")
    @SequenceGenerator(name = "relationship_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "friendship_requester_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "friendship_goal_id")
    private User recipient;

    private boolean isFriends;
}