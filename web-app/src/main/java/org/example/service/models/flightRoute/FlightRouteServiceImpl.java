package org.example.service.models.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.service.rest.models.flightRoute.FlightRouteRestTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceImpl implements FlightRouteService {

    private final FlightRouteRestTemplateService flightRouteRestTemplateService;


    @Override
    public List<FlightRouteDTOModif> readAll() {
        return flightRouteRestTemplateService.readAll();
    }

    @Override
    public FlightRouteDTOModif readById(Long id) {
        return flightRouteRestTemplateService.readById(id);
    }

    @Override
    public List<FlightRouteDTOModif> readAllByIds(List<Long> ids) {
        return flightRouteRestTemplateService.readAllByIds(ids);
    }

    @Override
    public FlightRouteDTOModif create(FlightRouteDTOModif flightRouteDTOModif) {
        return flightRouteRestTemplateService.create(flightRouteDTOModif);
    }

    @Override
    public FlightRouteDTOModif update(FlightRouteDTOModif flightRouteDTOModif) {
        return flightRouteRestTemplateService.update(flightRouteDTOModif);
    }

    @Override
    public FlightRouteDTOModif deleteById(Long id) {
        return flightRouteRestTemplateService.deleteById(id);
    }

    @Override
    public List<FlightRouteDTOModif> deleteAllByIds(List<Long> ids) {
        return flightRouteRestTemplateService.deleteAllByIds(ids);
    }
}
