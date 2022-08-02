package org.example.service.models.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.example.service.rest.models.flightRoute.FlightRouteRestTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceImpl implements FlightRouteService {

    private final FlightRouteRestTemplateService flightRouteRestTemplateService;


    @Override
    public List<FlightRouteDTOModif2> readAll() {
        return flightRouteRestTemplateService.readAll();
    }

    @Override
    public FlightRouteDTOModif2 readById(Long id) {
        return flightRouteRestTemplateService.readById(id);
    }

    @Override
    public List<FlightRouteDTOModif2> readAllByIds(List<Long> ids) {
        return flightRouteRestTemplateService.readAllByIds(ids);
    }

    @Override
    public FlightRouteDTOModif2 create(FlightRouteDTOModif2 flightRouteDTOModif2) {
        return flightRouteRestTemplateService.create(flightRouteDTOModif2);
    }

    @Override
    public FlightRouteDTOModif2 update(FlightRouteDTOModif2 flightRouteDTOModif2) {
        return flightRouteRestTemplateService.update(flightRouteDTOModif2);
    }

    @Override
    public FlightRouteDTOModif2 deleteById(Long id) {
        return flightRouteRestTemplateService.deleteById(id);
    }

    @Override
    public List<FlightRouteDTOModif2> deleteAllByIds(List<Long> ids) {
        return flightRouteRestTemplateService.deleteAllByIds(ids);
    }
}
