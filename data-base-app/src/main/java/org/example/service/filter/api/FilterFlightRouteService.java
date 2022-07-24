package org.example.service.filter.api;

import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;

import java.util.List;

public interface FilterFlightRouteService {
    List<FlightRoute> findFlightRouteWhereRouteStartAndRouteEnd(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereDateStartAndDateEnd(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereRouteSEOneWaypoint(FilterObj filterObj);
}

