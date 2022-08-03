package org.example.mapper.login;

import org.example.dto.LoginDTO;
import org.example.model.Authorities;
import org.example.model.Login;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginMapper {

    public Login toModel(LoginDTO loginDTO) {
        long authoritiesId;
        String authorities = loginDTO.getAuthorities();
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

        boolean isEnabled = loginDTO.getIsEnabled() != null;
        return Login.builder()
                .username(loginDTO.getUsername())
                .password(loginDTO.getPassword())
                .passwordConfirm(loginDTO.getPasswordConfirm())
                .authorities(List.of(Authorities.builder()
                        .id(authoritiesId)
                        .name(loginDTO.getAuthorities())
                        .build()))
                .isEnabled(isEnabled)
                .build();
    }
}
