package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.AirPlaneFlightRouteService;
import org.example.service.models.api.FlightRouteService;
import org.example.service.models.modif.api.FlightRouteServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceImplModif implements FlightRouteServiceModif {
    private final FlightRouteService flightRouteService;
    private final AirPlaneFlightRouteService airPlaneFlightRouteService;

    @Override
    public FlightRoute create(FlightRoute flightRoute) {
        return flightRouteService.create(flightRoute);
    }

    @Override
    public List<FlightRoute> readAll() {
        return flightRouteService.readAll();
    }

    @Override
    public FlightRoute readById(Long id) {
        return flightRouteService.readById(id);
    }

    @Override
    public List<FlightRoute> readAllByIds(List<Long> ids) {
        return flightRouteService.readAllByIds(ids);
    }

    @Override
    public FlightRoute deleteById(Long id) {
        return flightRouteService.deleteById(id);
    }

    @Override
    public List<FlightRoute> deleteAllByIds(List<Long> ids) {
        return flightRouteService.deleteAllByIds(ids);
    }

    @Override
    public FlightRoute update(FlightRoute flightRoute) {
        return flightRouteService.update(setForgetValueOnId(flightRoute));

    }

    private FlightRoute setForgetValueOnId(FlightRoute flightRoute) {
        if (flightRoute.getRouteStart() != null) {
            List<Long> airPlaneFlightRouteIdList = flightRoute.getAirPlaneFlightRouteList().stream().map(AirPlaneFlightRoute::getId).collect(Collectors.toList());
            List<AirPlaneFlightRoute> airPlaneFlightRouteFindList = airPlaneFlightRouteService.readAllByIds(airPlaneFlightRouteIdList);
            flightRoute.setAirPlaneFlightRouteList(airPlaneFlightRouteFindList);
            return flightRoute;
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }
}
