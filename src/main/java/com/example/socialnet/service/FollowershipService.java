package com.example.socialnet.service;

import com.example.socialnet.entities.Followership;

import java.util.List;

public interface FollowershipService {
    public List<Followership> getAllFollowerships();
    Followership findById(Long id);
    Followership save(Followership entity);
    void delete(Followership entity);
    Followership findByUser(Long userCheckedId, Long followerId);

}
