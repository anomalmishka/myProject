package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.mapper.filter.FilterMapper;
import org.example.mapper.models.modif.FlightRouteMapperModif;
import org.example.service.filter.api.FilterFlightRouteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/flight/route")
public class FilterFlightRouteController {
    private final FilterFlightRouteService filterFlightRouteService;
    private final FlightRouteMapperModif flightRouteMapperModif;
    private final FilterMapper filterMapper;

    @PostMapping(path = "find/route", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereRouteStartAndRouteEnd(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereRouteStartAndRouteEnd(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "find/date", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereDateStartAndDateEnd(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereDateStartAndDateEnd(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "find/route/one/waypoint", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereRouteSEOneWaypoint(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereRouteSEOneWaypoint(filterMapper.toModel(filterDTO)));
    }
}