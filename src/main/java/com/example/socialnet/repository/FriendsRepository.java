package com.example.socialnet.repository;

import com.example.socialnet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface FriendsRepository extends JpaRepository<User, Long> {

}