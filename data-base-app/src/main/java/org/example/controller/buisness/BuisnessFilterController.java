package org.example.controller.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dto.FilterDTO;
import org.example.dto.api.AirPlaneDTOModif;
import org.example.mapper.FilterMapper;
import org.example.mapper.api.AirPlaneMapperModif;
import org.example.service.api.BuisnessFilterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter")
public class BuisnessFilterController {
    private final BuisnessFilterService buisnessFilterService;
    private final AirPlaneMapperModif airPlaneMapperModif;
    private final FilterMapper filterMapper;

    @PostMapping(path = "find/route", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteStartAndRouteEnd(@RequestBody FilterDTO filterDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterService.findAirPlaneWhereRouteStartAndRouteEnd(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "find/date", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereDateStartAndDateEnd(@RequestBody FilterDTO filterDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterService.findAirPlaneWhereDateStartAndDateEnd(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "find/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWherePriceStartAndPriceEnd(@RequestBody FilterDTO filterDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterService.findAirPlaneWherePriceStartAndPriceEnd(filterMapper.toModel(filterDTO)));
    }

}

