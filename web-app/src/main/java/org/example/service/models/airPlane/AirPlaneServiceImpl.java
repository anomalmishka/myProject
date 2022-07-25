package org.example.service.models.airPlane;

import lombok.RequiredArgsConstructor;
import org.example.service.rest.filter.flightRoute.FlightRouteRestTemplateFilter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AirPlaneServiceImpl implements AirPlaneService {

    private final FlightRouteRestTemplateFilter flightRouteRestTemplateFilter;

//    @Override
//    public List<FlightRouteDTOModif> findRoute(FilterObj filterObj) {
//        if (filterObj.getRouteStart().equals(filterObj.getRouteEnd())) {
//            throw new ErrorInvalidData("Same Route");
//        } else {
//            return flightRouteRestTemplateFilter.exchangeFilterObj(filterObj, "find/route", HttpMethod.POST);
//        }
//    }
}
