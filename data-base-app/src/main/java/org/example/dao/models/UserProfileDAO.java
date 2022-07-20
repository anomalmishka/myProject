package org.example.dao.models;

import org.example.model.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDAO extends CrudRepository<UserProfile, Long> {
}
