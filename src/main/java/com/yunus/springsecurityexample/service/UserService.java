package com.yunus.springsecurityexample.service;

import com.yunus.springsecurityexample.model.User;
import com.yunus.springsecurityexample.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("username not found"));
    }

    public void addUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new RuntimeException("User already exist");
        }
        userRepository.save(user);
    }
}
