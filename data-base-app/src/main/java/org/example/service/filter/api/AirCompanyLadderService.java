package org.example.service.filter.api;

import org.example.model.entity.AirCompany;
import org.example.model.filter.FilterObj;

import java.util.List;

public interface AirCompanyLadderService {
    List<AirCompany> findAirCompanyWhereRouteStartAndRouteEnd(FilterObj filterObj);

    List<AirCompany> findAirCompanyWhereDateStartAndDateEnd(FilterObj filterObj);

    List<AirCompany> findAirCompanyWhereRouteSEOneWaypoint(FilterObj filterObj);
}

