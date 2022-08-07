package org.example.dao.custom.flightRoute;

import org.example.model.FlightRoute;
import org.example.dto.filter.FilterObj;

import java.util.List;

public interface FlightRouteCustomDAO {
    List<FlightRoute> filter(FilterObj filterObj);
    List<FlightRoute> findById(Long id);
}
