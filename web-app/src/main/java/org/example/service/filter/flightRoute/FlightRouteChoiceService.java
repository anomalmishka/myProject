package org.example.service.filter.flightRoute;

import org.example.model.Filter;
import org.example.model.database.FlightRoute;

import java.util.List;

public interface FlightRouteChoiceService {
    List<FlightRoute> selectFilter(Filter filter);
}
