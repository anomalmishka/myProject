package org.example.service.models.flightRouteCustom;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.dto.models.modif.AirPlaneFlightRouteDTOModif;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.service.models.airPlane.AirPlaneService;
import org.example.service.models.flightRoute.FlightRouteService;
import org.example.service.rest.models.flightRoute.FlightRouteRestTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceCustomImpl implements FlightRouteServiceCustom {
    private final FlightRouteService flightRouteService;
    private final AirPlaneService airPlaneService;

    @Override
    public FlightRouteDTOModif create(FlightRouteDTOModif flightRouteDTOModif, Long idAirPlane) {
        AirPlaneDTOModif airPlaneDTOModif = airPlaneService.readById(idAirPlane);
        flightRouteDTOModif.setId(null);
        flightRouteDTOModif.setAirPlaneFlightRouteList(
                List.of(AirPlaneFlightRouteDTOModif.builder()
                                .airPlane(airPlaneDTOModif)
                        .build())
        );
        return flightRouteService.create(flightRouteDTOModif);
    }

}
