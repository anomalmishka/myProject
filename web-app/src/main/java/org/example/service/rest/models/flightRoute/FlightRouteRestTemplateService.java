package org.example.service.rest.models.flightRoute;

import org.example.dto.models.modif.FlightRouteDTOModif;

import java.util.List;

public interface FlightRouteRestTemplateService {
    List<FlightRouteDTOModif> readAll();

    FlightRouteDTOModif readById(Long id);

    List<FlightRouteDTOModif> readAllByIds(List<Long> ids);

    FlightRouteDTOModif create(FlightRouteDTOModif flightRouteDTOModif);

    FlightRouteDTOModif update(FlightRouteDTOModif flightRouteDTOModif);

    FlightRouteDTOModif deleteById(Long id);

    List<FlightRouteDTOModif> deleteAllByIds(List<Long> ids);

}
