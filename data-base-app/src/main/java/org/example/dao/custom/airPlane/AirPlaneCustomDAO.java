package org.example.dao.custom.airPlane;

import org.example.model.filter.FilterAirPlaneObject;
import org.example.model.entity.AirPlane;

import java.util.List;

public interface AirPlaneCustomDAO {
    List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndDateSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);
    List<AirPlane> findAirPlaneWhereRouteSEOneWaypoint(FilterAirPlaneObject filterAirPlaneObject);

}
