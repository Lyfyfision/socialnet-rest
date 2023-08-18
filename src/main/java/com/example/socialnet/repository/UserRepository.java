package com.example.socialnet.repository;

import com.example.socialnet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

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