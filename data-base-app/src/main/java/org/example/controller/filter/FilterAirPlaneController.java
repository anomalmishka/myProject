package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterAirPlaneDTO;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.mapper.filter.FilterAirPlaneMapper;
import org.example.mapper.modelsMapper.modif.AirPlaneMapperModif;
import org.example.service.filter.api.FilterAirPlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/air/plane")
public class FilterAirPlaneController {
    private final FilterAirPlaneService filterAirPlaneService;
    private final AirPlaneMapperModif airPlaneMapperModif;
    private final FilterAirPlaneMapper filterAirPlaneMapper;

    @PostMapping(path = "find/route", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteStartAndRouteEnd(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWhereRouteStartAndRouteEnd(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/date", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereDateStartAndDateEnd(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWhereDateStartAndDateEnd(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWherePriceStartAndPriceEnd(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWherePriceStartAndPriceEnd(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/route/and/date", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteSEAndDateSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWhereRouteSEAndDateSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }
    @PostMapping(path = "find/route/and/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteSEAndPriceSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWhereRouteSEAndPriceSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/date/and/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereDateSEAndPriceSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWhereDateSEAndPriceSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/route/and/date/and/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteSEAndDateSEAndPriceSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWhereRouteSEAndDateSEAndPriceSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }
    @PostMapping(path = "find/route/one/waypoint", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteSEOneWaypoint(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(filterAirPlaneService.findAirPlaneWhereRouteSEOneWaypoint(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }
}

