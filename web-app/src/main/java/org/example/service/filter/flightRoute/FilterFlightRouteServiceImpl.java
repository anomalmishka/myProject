package org.example.service.filter.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.obj.database.modif.FlightRouteModif;
import org.example.model.obj.filter.FilterObj;
import org.example.service.rest.flightRoute.RestTemplateServiceFlightRoute;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterFlightRouteServiceImpl implements FilterFlightRouteService {

    private final RestTemplateServiceFlightRoute restTemplateServiceFlightRoute;

    @Override
    public List<FlightRouteModif> findRoute(FilterObj filterObj) {
        if (filterObj.getRouteStart().equals(filterObj.getRouteEnd())) {
            throw new ErrorInvalidData("Same Route");
        } else {
            return restTemplateServiceFlightRoute.exchangeFilterObj(filterObj, "find/route", HttpMethod.POST);
        }
    }
}
