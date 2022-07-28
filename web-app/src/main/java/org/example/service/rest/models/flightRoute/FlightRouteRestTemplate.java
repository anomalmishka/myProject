package org.example.service.rest.models.flightRoute;

import org.example.model.Filter;
import org.example.model.database.FlightRoute;
import org.springframework.http.HttpMethod;

import java.util.List;

public interface FlightRouteRestTemplate {
//    AirPlaneModif postAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar);
//
//    AirPlaneModif exchangeAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar, HttpMethod httpMethod);
//
//    AirPlaneModif exchangeAirPlaneModif(String uriVar, Long id, HttpMethod httpMethod);

    List<FlightRoute> exchangeFilterObj(Filter filter, String uriVar, HttpMethod httpMethod);
}
