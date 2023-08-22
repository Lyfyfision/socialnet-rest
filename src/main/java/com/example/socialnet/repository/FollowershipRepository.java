package com.example.socialnet.repository;

import com.example.socialnet.entities.Followership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowershipRepository extends JpaRepository<Followership, Long> {

    Optional<Followership> findFollowershipByUserCheckedIdAndFollowerId(Long userChecked_id, Long follower_id);
}