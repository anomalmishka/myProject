package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.mapper.filter.FilterMapper;
import org.example.mapper.models.modif.FlightRouteMapperModif;
import org.example.service.filter.api.FilterFlightRouteService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "find/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWherePriceStartAndPriceEnd(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWherePriceStartAndPriceEnd(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "find/route/and/date", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereRouteSEAndDateSE(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereRouteSEAndDateSE(filterMapper.toModel(filterDTO)));
    }
    @PostMapping(path = "find/route/and/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereRouteSEAndPriceSE(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereRouteSEAndPriceSE(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "find/date/and/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereDateSEAndPriceSE(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereDateSEAndPriceSE(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "find/route/and/date/and/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereRouteSEAndDateSEAndPriceSE(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereRouteSEAndDateSEAndPriceSE(filterMapper.toModel(filterDTO)));
    }
    @PostMapping(path = "find/route/one/waypoint", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> findFlightRouteWhereRouteSEOneWaypoint(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.findFlightRouteWhereRouteSEOneWaypoint(filterMapper.toModel(filterDTO)));
    }
}

