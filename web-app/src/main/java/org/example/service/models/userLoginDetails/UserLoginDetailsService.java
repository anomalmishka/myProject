package org.example.service.models.userLoginDetails;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserLoginDAO;
import org.example.model.UserLogin;
import org.example.service.models.userLoginPrincipal.UserLoginPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserLoginDetailsService implements UserDetailsService {

    private final UserLoginDAO userLoginDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userLoginDAO.findByUsername(username);
        if (userLogin == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("Could not find user");
        }
        return new UserLoginPrincipal(userLogin);
    }
}