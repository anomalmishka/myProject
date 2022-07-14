package org.example.dao;

import org.example.model.AirPlane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneDAO extends CrudRepository<AirPlane, Long> {
}
