package org.example.service.models.api;

import org.example.model.entity.AirPlaneFlightRoute;

import java.util.List;

public interface AirPlaneFlightRouteService {

    AirPlaneFlightRoute create(AirPlaneFlightRoute airPlaneFlightRoute);

    List<AirPlaneFlightRoute> readAll();

    AirPlaneFlightRoute readById(Long id);

    List<AirPlaneFlightRoute> readAllByIds(List<Long> ids);

    AirPlaneFlightRoute deleteById(Long id);

    List<AirPlaneFlightRoute> deleteAllByIds(List<Long> ids);

    AirPlaneFlightRoute update(AirPlaneFlightRoute airPlaneFlightRoute);
}

