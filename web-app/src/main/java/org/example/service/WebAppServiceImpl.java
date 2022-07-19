package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.AirPlaneDTOModif;
import org.example.exception.ErrorInvalidData;
import org.example.model.filter.FilterObj;
import org.example.service.interfaces.RestTemplateService;
import org.example.service.interfaces.WebAppService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WebAppServiceImpl implements WebAppService {

    private final RestTemplateService restTemplateService;

    @Override
    public List<AirPlaneDTOModif> findRoute(FilterObj filterObj) {
        if (filterObj.getRouteStart().equals(filterObj.getRouteEnd())) {
            throw new ErrorInvalidData("Same Route");
        } else {
            return restTemplateService.exchangeFilterObj(filterObj, "find/route", HttpMethod.POST);
        }
    }
}
