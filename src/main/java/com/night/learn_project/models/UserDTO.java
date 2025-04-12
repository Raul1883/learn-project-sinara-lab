package com.night.learn_project.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;


@Data
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private List<String> role;

    public UserDTO(User user) {
        userName = user.getUsername();
        role = user
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }

    public static UserDTO of(User user) {
        return new UserDTO(user);
    }
}
