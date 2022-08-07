package org.example.service.models.userLoginCustom;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserLoginCustomDAO;
import org.example.model.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserLoginCustomServiceImpl implements UserLoginCustomService {
    private final UserLoginCustomDAO userLoginCustomDAO;

    @Override
    public UserLogin findByUsername(String username) {
        List<UserLogin> userWhereUsername = userLoginCustomDAO.findUserWhereUsername(username);
        return userWhereUsername.stream().findFirst().orElse(null);
    }
}
