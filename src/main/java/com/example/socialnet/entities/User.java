package com.example.socialnet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Set;
/**
 * Represent User entity, including lists of friend and followers.
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    @NotBlank
    private String username;

    @Column(name = "e-mail", unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Column(name = "is_checked")
    private boolean isChecked;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "follower")
    @JsonIgnore
    private List<Followership> followers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userChecked")
    @JsonIgnore
    private List<Followership> following;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userReceiver")
    @JsonIgnore
    private List<Friendship> friendshipsReceived;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userSender")
    @JsonIgnore
    private List<Friendship> friendshipsSent;
    @PrePersist
    public void setUp() {
        this.isChecked = false;
    }
    public User(String username, String email, String password, boolean isChecked) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isChecked = isChecked;
    }
}