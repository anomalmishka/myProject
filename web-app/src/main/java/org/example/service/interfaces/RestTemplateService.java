package org.example.service.interfaces;

import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.model.filter.FilterObj;
import org.springframework.http.HttpMethod;

import java.util.List;

public interface RestTemplateService {
    AirPlaneDTOModif postAirPlaneDTOModif(AirPlaneDTOModif airPlaneDTOModif, String uriVar);

    AirPlaneDTOModif exchangeAirPlaneDTOModif(AirPlaneDTOModif airPlaneDTOModif, String uriVar, HttpMethod httpMethod);

    AirPlaneDTOModif exchangeAirPlaneDTOModif(String uriVar, Long id, HttpMethod httpMethod);

    List<AirPlaneDTOModif> exchangeFilterObj(FilterObj filterObj, String uriVar, HttpMethod httpMethod);
}
