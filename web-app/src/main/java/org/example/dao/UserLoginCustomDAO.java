package org.example.dao;

import org.example.model.UserLogin;

import java.util.List;

public interface UserLoginCustomDAO {
    List<UserLogin> findUserWhereUsername(String username);

}
