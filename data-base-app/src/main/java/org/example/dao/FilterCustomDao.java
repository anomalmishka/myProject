package org.example.dao;

import org.example.dto.api.FilterObject;
import org.example.model.AirPlane;

import java.util.List;

public interface FilterCustomDao {
    List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterObject filterObject);

    List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterObject filterObject);

    List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterObject filterObject);
}
