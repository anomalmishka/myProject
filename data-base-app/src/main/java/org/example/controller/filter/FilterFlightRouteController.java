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

    @PostMapping(path = "find", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> filter(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif.toDTO(filterFlightRouteService.filter(filterMapper.toModel(filterDTO)));
    }
}

