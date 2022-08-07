package org.example.service.models.admin;

import lombok.RequiredArgsConstructor;
import org.example.model.UserLogin;
import org.example.service.models.userLogin.UserLoginService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final UserLoginService userLoginService;
    @Override
    public UserLogin isAccountNonLockedChange(Long id) {
        UserLogin userLogin = userLoginService.readById(id);
        userLogin.setIsAccountNonLocked(!userLogin.getIsAccountNonLocked());
        return userLoginService.update(userLogin);
    }
}
