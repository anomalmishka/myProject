package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;
import org.example.service.filter.api.FilterFlightRouteService;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class FilterFlightRouteServiceImpl implements FilterFlightRouteService {

    private final FlightRouteCustomDAO flightRouteCustomDAO;

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteStartAndRouteEnd(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findFlightRouteWhereRouteStartAndRouteEnd(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereDateStartAndDateEnd(FilterObj filterObj) {
        if (filterObj.getDateStart() != null) {
            return flightRouteCustomDAO.findFlightRouteWhereDateStartAndDateEnd(filterObj);
        } else {
            throw new ErrorInvalidData("DateStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEOneWaypoint(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return flightRouteCustomDAO.findFlightRouteWhereRouteSEOneWaypoint(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }
}
