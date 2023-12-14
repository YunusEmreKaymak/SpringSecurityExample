package com.yunus.springsecurityexample.controller;

import com.yunus.springsecurityexample.dto.UsernameAndPassword;
import com.yunus.springsecurityexample.model.User;
import com.yunus.springsecurityexample.service.JwtService;
import com.yunus.springsecurityexample.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody UsernameAndPassword usernameAndPassword) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usernameAndPassword.getUserName(), usernameAndPassword.password));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(usernameAndPassword.getUserName());
        }
        throw new UsernameNotFoundException("invalid username {} " + usernameAndPassword.getUserName());
    }
}
