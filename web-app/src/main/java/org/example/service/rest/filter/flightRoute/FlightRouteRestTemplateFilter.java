package org.example.service.rest.filter.flightRoute;

import org.example.dto.filter.FilterDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;

import java.util.List;

public interface FlightRouteRestTemplateFilter {
    List<FlightRouteDTOModif> exchangeFilterToFlightRoute(FilterDTO filterDTO, String uriVar);
    List<FlightRouteDTOModif> findById(Long id);
}
