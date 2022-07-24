package org.example.service.rest.flightRoute;

import org.example.model.obj.database.modif.FlightRouteModif;
import org.example.model.obj.filter.FilterObj;
import org.springframework.http.HttpMethod;

import java.util.List;

public interface RestTemplateServiceFlightRoute {
//    AirPlaneModif postAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar);
//
//    AirPlaneModif exchangeAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar, HttpMethod httpMethod);
//
//    AirPlaneModif exchangeAirPlaneModif(String uriVar, Long id, HttpMethod httpMethod);

    List<FlightRouteModif> exchangeFilterObj(FilterObj filterObj, String uriVar, HttpMethod httpMethod);
}
