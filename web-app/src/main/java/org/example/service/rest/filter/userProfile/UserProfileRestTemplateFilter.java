package org.example.service.rest.filter.userProfile;

import org.example.model.Filter;
import org.example.model.database.UserProfile;
import org.springframework.http.HttpMethod;

import java.util.List;

public interface UserProfileRestTemplateFilter {
//    AirPlaneModif postAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar);
//
//    AirPlaneModif exchangeAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar, HttpMethod httpMethod);
//
//    AirPlaneModif exchangeAirPlaneModif(String uriVar, Long id, HttpMethod httpMethod);

    List<UserProfile> exchange(Filter filter, String uriVar, HttpMethod httpMethod);
}
