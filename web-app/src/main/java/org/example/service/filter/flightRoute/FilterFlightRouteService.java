package org.example.service.filter.flightRoute;

import org.example.model.obj.database.modif.FlightRouteModif;
import org.example.model.obj.filter.FilterObj;

import java.util.List;

public interface FilterFlightRouteService {

    List<FlightRouteModif> findRoute(FilterObj filterObj);
}
