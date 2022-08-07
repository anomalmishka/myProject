package org.example.dao.crud;

import org.example.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDAO extends CrudRepository<UserProfile, Long> {
}
