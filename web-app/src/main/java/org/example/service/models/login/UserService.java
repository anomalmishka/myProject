package org.example.service.models.login;

import org.example.model.Login;

import java.util.List;

public interface UserService {
    List<Login> readAll();

    Login readById(Long id);

    List<Login> readAllByIds(List<Long> ids);

    Login create(Login loginProfileDTO);

    Login update(Login loginProfileDTO);

    Login deleteById(Long id);

    List<Login> deleteAllByIds(List<Long> ids);

    Login findByUsername(String username);
}
