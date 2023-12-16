package com.yunus.springsecurityexample.service;

import com.yunus.springsecurityexample.dto.UserDto;
import com.yunus.springsecurityexample.dto.UserDtoConverter;
import com.yunus.springsecurityexample.model.User;
import com.yunus.springsecurityexample.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter dtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter dtoConverter) {
        this.userRepository = userRepository;
        this.dtoConverter = dtoConverter;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(dtoConverter::userToUserDto).toList();
    }



    public void addUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("User already exist");
        }
        userRepository.save(new User(
                userDto.getName(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.isAccountNonExpired(),
                userDto.isEnabled(),
                userDto.isAccountNonLocked(),
                userDto.isCredentialsNonExpired(),
                userDto.getAuthorities()
        ));
    }
}
