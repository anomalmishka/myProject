package org.example.service.api;

import org.example.model.entity.FlightRoute;

import java.util.List;

public interface FlightRouteService {

    FlightRoute create(FlightRoute flightRoute);

    List<FlightRoute> readAll();

    FlightRoute readById(Long id);

    List<FlightRoute> readAllByIds(List<Long> ids);

    FlightRoute deleteById(Long id);

    List<FlightRoute> deleteAllByIds(List<Long> ids);

    FlightRoute update(FlightRoute flightRoute);
}

