package com.example.socialnet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String imageUrl;

}