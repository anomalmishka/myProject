package org.example.service.rest.models.flightRoute;

import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;

import java.util.List;

public interface FlightRouteRestTemplateService {
    List<FlightRouteDTOModif2> readAll();

    FlightRouteDTOModif2 readById(Long id);

    List<FlightRouteDTOModif2> readAllByIds(List<Long> ids);

    FlightRouteDTOModif2 create(FlightRouteDTOModif2 flightRouteDTOModif2);

    FlightRouteDTOModif2 update(FlightRouteDTOModif2 flightRouteDTOModif2);

    FlightRouteDTOModif2 deleteById(Long id);

    List<FlightRouteDTOModif2> deleteAllByIds(List<Long> ids);

}
