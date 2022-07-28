package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.dto.ladder.AirCompanyDTOLadder;
import org.example.mapper.filter.FilterMapper;
import org.example.mapper.ladder.AirCompanyMapperLadder;
import org.example.service.filter.api.AirCompanyLadderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/air/company")
public class AirCompanyLadderController {
    private final AirCompanyLadderService airCompanyLadderService;
    private final AirCompanyMapperLadder airCompanyMapperLadder;
    private final FilterMapper filterMapper;

    @PostMapping(path = "where/route", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOLadder> findFlightRouteWhereRouteStartAndRouteEnd(@RequestBody FilterDTO filterDTO) {
        return airCompanyMapperLadder.toDTO(airCompanyLadderService.findAirCompanyWhereRouteStartAndRouteEnd(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOLadder> findFlightRouteWhereDateStartAndDateEnd(@RequestBody FilterDTO filterDTO) {
        return airCompanyMapperLadder.toDTO(airCompanyLadderService.findAirCompanyWhereDateStartAndDateEnd(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/one/waypoint", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOLadder> findFlightRouteWhereRouteSEOneWaypoint(@RequestBody FilterDTO filterDTO) {
        return airCompanyMapperLadder.toDTO(airCompanyLadderService.findAirCompanyWhereRouteSEOneWaypoint(filterMapper.toModel(filterDTO)));
    }
}

