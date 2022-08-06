package org.example.dao.crud;

import org.example.model.AirPlaneFlightRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneFlightRouteDAO extends CrudRepository<AirPlaneFlightRoute, Long> {
}
