package org.example.mapper.userLogin;

import org.example.dto.UserLoginDTO;
import org.example.model.Authorities;
import org.example.model.UserLogin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserLoginMapper {

    public UserLogin toModel(UserLoginDTO userLoginDTO) {
        long authoritiesId;
        String authorities = userLoginDTO.getAuthorities();
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
        return UserLogin.builder()
                .username(userLoginDTO.getUsername())
                .password(userLoginDTO.getPassword())
                .passwordConfirm(userLoginDTO.getPasswordConfirm())
                .authorities(List.of(Authorities.builder()
                        .id(authoritiesId)
                        .authorities_name(userLoginDTO.getAuthorities())
                        .build()))
                .isAccountNonExpired(userLoginDTO.getIsAccountNonExpired() != null)
                .isAccountNonLocked(userLoginDTO.getIsAccountNonLocked() != null)
                .isCredentialsNonExpired(userLoginDTO.getIsCredentialsNonExpired() != null)
                .isEnabled(userLoginDTO.getIsEnabled() != null)
                .build();
    }
}
