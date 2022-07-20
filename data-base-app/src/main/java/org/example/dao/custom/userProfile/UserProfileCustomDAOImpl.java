package org.example.dao.custom.userProfile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
@RequiredArgsConstructor
@Repository
public class UserProfileCustomDAOImpl implements UserProfileCustomDAO {
    private final EntityManagerFactory entityManagerFactory;
}