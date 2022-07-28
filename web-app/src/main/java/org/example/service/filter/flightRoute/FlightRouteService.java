package org.example.service.filter.flightRoute;

import org.example.model.database.FlightRoute;
import org.example.model.Filter;

import java.util.List;

public interface FlightRouteService {

    List<FlightRoute> findRoute(Filter filter);
}
