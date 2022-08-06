package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.service.rest.filter.flightRoute.FlightRouteRestTemplateFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindFlightRouteByFilterServiceImpl implements FindFlightRouteByFilterService {

    private final FlightRouteRestTemplateFilter flightRouteRestTemplateFilter;

    @Override
    public List<FlightRouteDTOModif> findByCondition(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"find");
    }
}
