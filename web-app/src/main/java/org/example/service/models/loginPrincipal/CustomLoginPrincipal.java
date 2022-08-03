package org.example.service.models.loginPrincipal;

import lombok.RequiredArgsConstructor;
import org.example.model.Authorities;
import org.example.model.Login;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@RequiredArgsConstructor
public class CustomLoginPrincipal implements UserDetails {

    private final Login login;

    @Override
    public List<Authorities> getAuthorities() {
        return login.getAuthorities();
    }

    @Override
    public String getPassword() {
        return login.getPassword();
    }

    @Override
    public String getUsername() {
        return login.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return login.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return login.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return login.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return login.isEnabled();
    }
}