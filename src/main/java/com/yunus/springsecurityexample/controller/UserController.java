package com.yunus.springsecurityexample.controller;

import com.yunus.springsecurityexample.model.User;
import com.yunus.springsecurityexample.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}
