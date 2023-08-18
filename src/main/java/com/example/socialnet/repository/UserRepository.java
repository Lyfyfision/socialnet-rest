package com.example.socialnet.repository;

import com.example.socialnet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    @Override
    boolean existsById(Long aLong);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<User> getUserByEmail(@Param("email") String email);
}