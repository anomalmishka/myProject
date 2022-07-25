package org.example.service.rest.filter.userProfile;

import org.example.model.database.UserProfile;
import org.example.model.FilterObj;
import org.springframework.http.HttpMethod;

import java.util.List;

public interface UserProfileRestTemplateFilter {
//    AirPlaneModif postAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar);
//
//    AirPlaneModif exchangeAirPlaneModif(AirPlaneModif airPlaneDTOModif, String uriVar, HttpMethod httpMethod);
//
//    AirPlaneModif exchangeAirPlaneModif(String uriVar, Long id, HttpMethod httpMethod);

    List<UserProfile> exchange(FilterObj filterObj, String uriVar, HttpMethod httpMethod);
}
