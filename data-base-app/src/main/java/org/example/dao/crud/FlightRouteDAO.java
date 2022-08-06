package org.example.dao.crud;

import org.example.model.FlightRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRouteDAO extends CrudRepository<FlightRoute, Long> {
}
