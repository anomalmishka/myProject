package org.example.service.filter.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.database.FlightRoute;
import org.example.model.FilterObj;
import org.example.service.rest.filter.flightRoute.FlightRouteRestTemplateFilter;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceImpl implements FlightRouteService {

    private final FlightRouteRestTemplateFilter flightRouteRestTemplateFilter;

    @Override
    public List<FlightRoute> findRoute(FilterObj filterObj) {
        if (filterObj.getRouteStart().equals(filterObj.getRouteEnd())) {
            throw new ErrorInvalidData("Same Route");
        } else {
            return flightRouteRestTemplateFilter.exchangeFilterObj(filterObj, "find/route", HttpMethod.POST);
        }
    }
}
