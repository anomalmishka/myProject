package org.example.dao.models;

import org.example.model.entity.AirPlane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneDAO extends CrudRepository<AirPlane, Long> {
}
