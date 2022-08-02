package org.example.dao.models;

import org.example.model.entity.AirPlaneFlightRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneFlightRouteDAO extends CrudRepository<AirPlaneFlightRoute, Long> {
}
