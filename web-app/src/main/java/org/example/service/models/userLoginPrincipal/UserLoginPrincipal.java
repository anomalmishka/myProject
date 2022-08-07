package org.example.service.models.userLoginPrincipal;

import lombok.RequiredArgsConstructor;
import org.example.model.Authorities;
import org.example.model.UserLogin;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@RequiredArgsConstructor
public class UserLoginPrincipal implements UserDetails {

    private final UserLogin userLogin;

    @Override
    public String getUsername() {
        return userLogin.getUsername();
    }

    @Override
    public String getPassword() {
        return userLogin.getPassword();
    }

    @Override
    public List<Authorities> getAuthorities() {
        return userLogin.getAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userLogin.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
          return userLogin.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userLogin.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userLogin.isEnabled();
    }
}