package org.example.service.models.flightRouteCustom;

import org.example.dto.models.modif.FlightRouteDTOModif;

public interface FlightRouteServiceCustom {
    FlightRouteDTOModif create(FlightRouteDTOModif flightRouteDTOModif, Long idAirPlane);
}
