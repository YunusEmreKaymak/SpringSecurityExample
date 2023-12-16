package com.yunus.springsecurityexample.dto;

import com.yunus.springsecurityexample.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto userToUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.isAccountNonExpired(),
                user.isEnabled(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.getAuthorities()
        );
    }
}
