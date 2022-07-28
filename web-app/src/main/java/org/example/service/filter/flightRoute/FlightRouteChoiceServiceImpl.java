package org.example.service.filter.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.model.Filter;
import org.example.model.database.FlightRoute;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightRouteChoiceServiceImpl implements FlightRouteChoiceService {

    private final FlightRouteService flightRouteService;

    @Override
    public List<FlightRoute> selectFilter(Filter filter) {

        if ((filter.getRouteStart() != null) &&
                (filter.getRouteStart() != null) &&
                (filter.getDateStart() != null) &&
                (filter.getDateEnd() != null) &&
                (filter.getPriceStart() == null) &&
                (filter.getPriceEnd() == null)
        ) {
            return flightRouteService.findRoute(filter);
        } else {
            if ((filter.getRouteStart() != null) &&
                    (filter.getRouteStart() != null) &&
                    (filter.getDateStart() != null) &&
                    (filter.getDateEnd() != null) &&
                    (filter.getPriceStart() == null) &&
                    (filter.getPriceEnd() == null)
            ) {
                return flightRouteService.findRoute(filter);
            } else {
                if ((filter.getRouteStart() != null) &&
                        (filter.getRouteStart() != null) &&
                        (filter.getDateStart() == null) &&
                        (filter.getDateEnd() == null) &&
                        (filter.getPriceStart() == null) &&
                        (filter.getPriceEnd() == null)
                ) {
                    return flightRouteService.findRoute(filter);
                } else {
                    if ((filter.getRouteStart() != null) &&
                            (filter.getRouteStart() == null) &&
                            (filter.getDateStart() == null) &&
                            (filter.getDateEnd() == null) &&
                            (filter.getPriceStart() == null) &&
                            (filter.getPriceEnd() == null)
                    ) {
                        return flightRouteService.findRoute(filter);
                    }
                    else {
                        if ((filter.getRouteStart() == null) &&
                                (filter.getRouteStart() != null) &&
                                (filter.getDateStart() == null) &&
                                (filter.getDateEnd() == null) &&
                                (filter.getPriceStart() == null) &&
                                (filter.getPriceEnd() == null)
                        ) {
                            return flightRouteService.findRoute(filter);
                        } else
                        if ((filter.getRouteStart() != null) &&
                                (filter.getRouteStart() != null) &&
                                (filter.getDateStart() != null) &&
                                (filter.getDateEnd() == null) &&
                                (filter.getPriceStart() == null) &&
                                (filter.getPriceEnd() == null)
                        ) {
                            return flightRouteService.findRoute(filter);
                        }
                    }
                }
            }
        }
        return flightRouteService.findRoute(filter); // findAll
    }
}
