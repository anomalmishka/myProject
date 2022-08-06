package org.example.dao;

import org.example.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDAO extends JpaRepository<UserLogin, Long> {
    UserLogin findByUsername(String username);
}
