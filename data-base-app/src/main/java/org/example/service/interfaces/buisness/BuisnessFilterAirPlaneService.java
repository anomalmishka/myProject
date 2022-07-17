package org.example.service.interfaces.buisness;

import org.example.model.filter.FilterAirPlaneObject;
import org.example.model.entity.AirPlane;

import java.util.List;

public interface BuisnessFilterAirPlaneService {
    List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndDateSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);
    List<AirPlane> findAirPlaneWhereRouteSEOneWaypoint(FilterAirPlaneObject filterAirPlaneObject);
}

