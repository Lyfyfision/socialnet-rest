package com.example.socialnet.service.impl;

import com.example.socialnet.entities.Followership;
import com.example.socialnet.repository.FollowershipRepository;
import com.example.socialnet.service.FollowershipService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class FollowershipServiceImpl implements FollowershipService {

    private final FollowershipRepository followRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Followership> getAllFollowerships() {
        return followRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Followership findById(Long id) {
        return followRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public Followership save(Followership entity) {
        return followRepo.save(entity);
    }

    @Override
    @Transactional
    public void delete(Followership entity) {
        followRepo.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Followership findByUser(Long userCheckedId, Long followerId) {
        return followRepo.findFollowershipByUserCheckedIdAndFollowerId(userCheckedId, followerId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
