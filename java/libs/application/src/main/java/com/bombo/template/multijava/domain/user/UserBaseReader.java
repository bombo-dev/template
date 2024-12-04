package com.bombo.template.multijava.domain.user;

import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class UserBaseReader implements UserReader {
    private final UserRepository userRepository;

    public UserBaseReader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }
}
