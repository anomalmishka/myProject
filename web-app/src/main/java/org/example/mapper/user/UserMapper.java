package org.example.mapper.user;

import org.example.dto.UserDTO;
import org.example.model.Authorities;
import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User toModel(UserDTO userDTO) {
        long authoritiesId;
        String authorities = userDTO.getAuthorities();
        if (authorities.equals("USER")) {
            authoritiesId = 1L;
        } else {
            if (authorities.equals("MANAGER")) {
                authoritiesId = 2L;
            } else {
                if (authorities.equals("ADMIN")) {
                    authoritiesId = 3L;
                } else {
                    authoritiesId = 1L;
                }
            }
        }

        boolean isEnabled = userDTO.getIsEnabled() != null;
        return User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .passwordConfirm(userDTO.getPasswordConfirm())
                .authorities(List.of(Authorities.builder()
                        .id(authoritiesId)
                        .name(userDTO.getAuthorities())
                        .build()))
                .isEnabled(isEnabled)
                .build();
    }
}
