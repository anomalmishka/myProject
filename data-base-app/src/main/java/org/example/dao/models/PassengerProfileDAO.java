package org.example.dao.models;

import org.example.model.entity.PassengerProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerProfileDAO extends CrudRepository<PassengerProfile, Long> {
}
