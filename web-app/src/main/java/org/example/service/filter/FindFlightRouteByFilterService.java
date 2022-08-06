package org.example.service.filter;

import org.example.dto.filter.FilterDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;

import java.util.List;

public interface FindFlightRouteByFilterService {
        List<FlightRouteDTOModif> findByCondition(FilterDTO filterDTO);
}