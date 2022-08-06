package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.model.FlightRoute;
import org.example.dto.filter.FilterObj;
import org.example.service.filter.api.FilterFlightRouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterFlightRouteServiceImpl implements FilterFlightRouteService {

    private final FlightRouteCustomDAO flightRouteCustomDAO;

    @Override
    public List<FlightRoute> filter(FilterObj filterObj) {
        return flightRouteCustomDAO.filter(filterObj);
    }
}
