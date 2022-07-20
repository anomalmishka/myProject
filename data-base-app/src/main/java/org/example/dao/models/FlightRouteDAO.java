package org.example.dao.models;

import org.example.model.entity.FlightRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRouteDAO extends CrudRepository<FlightRoute, Long> {
}
