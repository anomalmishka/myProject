package org.example.service.models.userDetails;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.service.models.userPrincipal.CustomUserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
        return new CustomUserPrincipal(user);
    }
}