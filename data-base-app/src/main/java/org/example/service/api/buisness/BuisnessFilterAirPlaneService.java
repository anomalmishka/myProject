package org.example.service.api.buisness;

import org.example.dto.api.FilterAirPlaneObject;
import org.example.model.AirPlane;

import java.util.List;

public interface BuisnessFilterAirPlaneService {
    List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndDateSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);

    List<AirPlane> findAirPlaneWhereRouteSEAndDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject);
}

