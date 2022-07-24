package org.example.dao.custom.flightRoute;

import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;

import java.util.List;
public interface FlightRouteCustomDAO {
    List<FlightRoute> findFlightRouteWhereRouteStartAndRouteEnd(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereDateStartAndDateEnd(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereRouteSEOneWaypoint(FilterObj filterObj);
}
