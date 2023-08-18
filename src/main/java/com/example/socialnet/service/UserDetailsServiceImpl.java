package com.example.socialnet.service;

import com.example.socialnet.model.User;
import com.example.socialnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        UserBuilder builder = null;
        if(user.isPresent()) {
            User currentUser = user.get();
            org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(currentUser.getPassword());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}
