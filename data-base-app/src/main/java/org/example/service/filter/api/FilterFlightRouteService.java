package org.example.service.filter.api;

import org.example.model.FlightRoute;
import org.example.dto.filter.FilterObj;

import java.util.List;

public interface FilterFlightRouteService {
    List<FlightRoute> filter(FilterObj filterObj);
}

