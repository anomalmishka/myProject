package org.example.service.rest.filter.flightRoute;

import org.example.model.database.FlightRoute;
import org.example.model.FilterObj;
import org.springframework.http.HttpMethod;

import java.util.List;

public interface FlightRouteRestTemplateFilter {
//    AirPlaneModif postAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar);
//
//    AirPlaneModif exchangeAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar, HttpMethod httpMethod);
//
//    AirPlaneModif exchangeAirPlaneModif(String uriVar, Long id, HttpMethod httpMethod);

    List<FlightRoute> exchangeFilterObj(FilterObj filterObj, String uriVar, HttpMethod httpMethod);
}
