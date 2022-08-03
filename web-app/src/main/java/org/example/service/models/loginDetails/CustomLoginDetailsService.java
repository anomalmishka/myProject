package org.example.service.models.loginDetails;

import lombok.RequiredArgsConstructor;
import org.example.dao.LoginDAO;
import org.example.model.Login;
import org.example.service.models.loginPrincipal.CustomLoginPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomLoginDetailsService implements UserDetailsService {

    private final LoginDAO loginDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginDAO.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
        return new CustomLoginPrincipal(login);
    }
}