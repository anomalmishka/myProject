package org.example.service.models.userLogin;

import org.example.model.UserLogin;

import java.util.List;

public interface UserLoginService {
    List<UserLogin> readAll();

    UserLogin readById(Long id);

    List<UserLogin> readAllByIds(List<Long> ids);

    UserLogin create(UserLogin userLoginProfileDTO);

    UserLogin update(UserLogin userLoginProfileDTO);

    UserLogin deleteById(Long id);

    List<UserLogin> deleteAllByIds(List<Long> ids);

    UserLogin findByUsername(String username);
}
