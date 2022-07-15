package org.example.service.api;

import org.example.dto.api.FilterObject;
import org.example.model.AirPlane;

import java.util.List;

public interface BuisnessFilterService {
    List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterObject filterObject);

    List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterObject filterObject);

    List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterObject filterObject);
}

