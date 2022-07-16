package org.example.controller.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dto.FilterAirPlaneDTO;
import org.example.dto.api.AirPlaneDTOModif;
import org.example.mapper.FilterAirPlaneMapper;
import org.example.mapper.api.AirPlaneMapperModif;
import org.example.service.api.buisness.BuisnessFilterAirPlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/air/plane")
public class BuisnessFilterAirPlaneController {
    private final BuisnessFilterAirPlaneService buisnessFilterAirPlaneService;
    private final AirPlaneMapperModif airPlaneMapperModif;
    private final FilterAirPlaneMapper filterAirPlaneMapper;

    @PostMapping(path = "find/route", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteStartAndRouteEnd(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterAirPlaneService.findAirPlaneWhereRouteStartAndRouteEnd(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/date", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereDateStartAndDateEnd(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterAirPlaneService.findAirPlaneWhereDateStartAndDateEnd(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWherePriceStartAndPriceEnd(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterAirPlaneService.findAirPlaneWherePriceStartAndPriceEnd(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/route/and/date", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteSEAndDateSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterAirPlaneService.findAirPlaneWhereRouteSEAndDateSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }
    @PostMapping(path = "find/route/and/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteSEAndPriceSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterAirPlaneService.findAirPlaneWhereRouteSEAndPriceSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/date/and/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereDateSEAndPriceSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterAirPlaneService.findAirPlaneWhereDateSEAndPriceSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

    @PostMapping(path = "find/route/and/date/and/price", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> findAirPlaneWhereRouteSEAndDateSEAndPriceSE(@RequestBody FilterAirPlaneDTO filterAirPlaneDTO) {
        return airPlaneMapperModif.toDTO(buisnessFilterAirPlaneService.findAirPlaneWhereRouteSEAndDateSEAndPriceSE(filterAirPlaneMapper.toModel(filterAirPlaneDTO)));
    }

}

