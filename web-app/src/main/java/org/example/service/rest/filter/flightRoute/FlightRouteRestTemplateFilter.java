package org.example.service.rest.filter.flightRoute;

import org.example.dto.FilterDTO;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;

import java.util.List;

public interface FlightRouteRestTemplateFilter {
    List<FlightRouteDTOModif2> exchangeFilterToFlightRoute(FilterDTO filterDTO, String uriVar);
    List<FlightRouteDTOModif2> findAll();
}
