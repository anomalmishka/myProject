package org.example.service.filter.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.model.Filter;
import org.example.model.database.FlightRoute;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HomeServiceImpl implements HomeService {

    private final FlightRouteService flightRouteService;

    @Override
    public List<FlightRoute> selectFilter(Filter filter) {
        if ((filter.getRouteStartCheckbox()) &&
                (filter.getRouteEndCheckbox()) &&
                (filter.getDateStartCheckbox()) &&
                (filter.getDateEndCheckbox()) &&
                (filter.getPriceStartCheckbox()) &&
                (filter.getAirCompanyCheckbox()) &&
                (filter.getTransfersCheckbox()) &&
                (filter.getFlightDurationCheckbox())
        ) {
            return flightRouteService.findRoute(filter);
        } else {
            flightRouteService.findRoute(filter);
        }
        return flightRouteService.findRoute(filter);
    }
}
