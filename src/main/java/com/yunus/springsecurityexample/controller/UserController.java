package com.yunus.springsecurityexample.controller;

import com.yunus.springsecurityexample.dto.UserDto;
import com.yunus.springsecurityexample.dto.UsernameAndPassword;
import com.yunus.springsecurityexample.securityservice.JwtService;
import com.yunus.springsecurityexample.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
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
