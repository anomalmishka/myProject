package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.model.AirPlane;
import org.example.model.AirPlaneFlightRoute;
import org.example.service.models.api.AirPlaneFlightRouteService;
import org.example.service.models.api.AirPlaneService;
import org.example.service.modif.api.AirPlaneFlightRouteServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirPlaneFlightRouteServiceImplModif implements AirPlaneFlightRouteServiceModif {

    private final AirPlaneFlightRouteService airPlaneFlightRouteService;
    private final AirPlaneService airPlaneService;

    @Override
    public AirPlaneFlightRoute create(AirPlaneFlightRoute airPlaneFlightRoute) {
        return airPlaneFlightRouteService.create(airPlaneFlightRoute);
    }

    @Override
    public List<AirPlaneFlightRoute> readAll() {
        return airPlaneFlightRouteService.readAll();
    }

    @Override
    public AirPlaneFlightRoute readById(Long id) {
        return airPlaneFlightRouteService.readById(id);
    }

    @Override
    public List<AirPlaneFlightRoute> readAllByIds(List<Long> ids) {
        return airPlaneFlightRouteService.readAllByIds(ids);
    }

    @Override
    public AirPlaneFlightRoute deleteById(Long id) {
        return airPlaneFlightRouteService.deleteById(id);
    }

    @Override
    public List<AirPlaneFlightRoute> deleteAllByIds(List<Long> ids) {
        return airPlaneFlightRouteService.deleteAllByIds(ids);
    }

    @Override
    public AirPlaneFlightRoute update(AirPlaneFlightRoute airPlaneFlightRoute) {
            return airPlaneFlightRouteService.update(setForgetValueOnId(airPlaneFlightRoute));
    }

    private AirPlaneFlightRoute setForgetValueOnId(AirPlaneFlightRoute airPlaneFlightRoute) {
        if (airPlaneFlightRoute.getAirPlane().getId() != null) {
            Long airPlaneId = airPlaneFlightRoute.getAirPlane().getId();
            AirPlane airPlane = airPlaneService.readById(airPlaneId);
            airPlaneFlightRoute.setAirPlane(airPlane);
            return airPlaneFlightRoute;
        } else {
            return airPlaneFlightRoute;
        }
    }
}
