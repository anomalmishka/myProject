package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
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
        return flightRouteCustomDAO.findFlightRouteWhereRouteStartAndRouteEnd(filterObj);
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereDateStartAndDateEnd(FilterObj filterObj) {
        return flightRouteCustomDAO.findFlightRouteWhereDateStartAndDateEnd(filterObj);
    }

    @Override
    public List<FlightRoute> findFlightRouteWherePriceStartAndPriceEnd(FilterObj filterObj) {
        return flightRouteCustomDAO.findFlightRouteWherePriceStartAndPriceEnd(filterObj);
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEAndDateSE(FilterObj filterObj) {
        return flightRouteCustomDAO.findFlightRouteWhereRouteSEAndDateSE(filterObj);
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEAndPriceSE(FilterObj filterObj) {
        return flightRouteCustomDAO.findFlightRouteWhereRouteSEAndPriceSE(filterObj);
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereDateSEAndPriceSE(FilterObj filterObj) {
        return flightRouteCustomDAO.findFlightRouteWhereDateSEAndPriceSE(filterObj);
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEAndDateSEAndPriceSE(FilterObj filterObj) {
        return flightRouteCustomDAO.findFlightRouteWhereRouteSEAndDateSEAndPriceSE(filterObj);
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEOneWaypoint(FilterObj filterObj) {
        return flightRouteCustomDAO.findFlightRouteWhereRouteSEOneWaypoint(filterObj);
    }
}
