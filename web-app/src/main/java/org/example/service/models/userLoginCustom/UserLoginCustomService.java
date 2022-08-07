package org.example.service.models.userLoginCustom;

import org.example.model.UserLogin;

public interface UserLoginCustomService {
    UserLogin findByUsername(String username);
}
