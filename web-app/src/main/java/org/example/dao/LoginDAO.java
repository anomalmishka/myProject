package org.example.dao;

import org.example.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
