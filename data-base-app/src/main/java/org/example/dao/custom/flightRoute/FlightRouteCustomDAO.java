package org.example.dao.custom.flightRoute;

import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;

import java.util.List;
public interface FlightRouteCustomDAO {
    List<FlightRoute> findFlightRouteWhereRouteStartAndRouteEnd(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereDateStartAndDateEnd(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWherePriceStartAndPriceEnd(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereRouteSEAndDateSE(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereRouteSEAndPriceSE(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereDateSEAndPriceSE(FilterObj filterObj);

    List<FlightRoute> findFlightRouteWhereRouteSEAndDateSEAndPriceSE(FilterObj filterObj);
    List<FlightRoute> findFlightRouteWhereRouteSEOneWaypoint(FilterObj filterObj);
}
