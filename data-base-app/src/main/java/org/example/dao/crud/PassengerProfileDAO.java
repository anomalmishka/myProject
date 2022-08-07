package org.example.dao.crud;

import org.example.model.PassengerProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerProfileDAO extends CrudRepository<PassengerProfile, Long> {
}
