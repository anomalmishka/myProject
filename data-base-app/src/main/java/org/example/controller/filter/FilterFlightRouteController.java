package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.example.mapper.filter.FilterMapper;
import org.example.mapper.models.modif2.FlightRouteMapperModif2;
import org.example.service.filter.api.FilterFlightRouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/flight/route")
public class FilterFlightRouteController {
    private final FilterFlightRouteService filterFlightRouteService;
    private final FlightRouteMapperModif2 flightRouteMapperModif2;
    private final FilterMapper filterMapper;

    //**************************************1***************************************************

    @PostMapping(path = "where/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/start", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteStart(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteStart(filterMapper.toModel(filterDTO)));
    }

    //**************************************2***************************************************
    @PostMapping(path = "where/route", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRoute(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRoute(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDate(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDate(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWherePrice(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWherePrice(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDuration(filterMapper.toModel(filterDTO)));
    }

    //**************************************3***************************************************
    @PostMapping(path = "where/route/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDateName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDateName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/price/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWherePriceName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWherePriceName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteTransfer(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteTransfer(filterMapper.toModel(filterDTO)));
    }

    //**************************************4***************************************************

    @PostMapping(path = "where/route/date", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDate(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDate(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRoutePrice(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRoutePrice(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDatePrice(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDatePrice(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDuration(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDateDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDateDuration(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/price/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWherePriceDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWherePriceDuration(filterMapper.toModel(filterDTO)));
    }
    //**************************************5***************************************************

    @PostMapping(path = "where/route/date/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDateName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDateName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/price/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRoutePriceName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRoutePriceName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/duration/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDurationName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDurationName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date/price/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDatePriceName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDatePriceName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date/duration/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDateDurationName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDateDurationName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/price/duration/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWherePriceDurationName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWherePriceDurationName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/date/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDateTransfer(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDateTransfer(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/price/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRoutePriceTransfer(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRoutePriceTransfer(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/duration/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDurationTransfer(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDurationTransfer(filterMapper.toModel(filterDTO)));
    }

    //**************************************6***************************************************


    @PostMapping(path = "where/route/date/price", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDatePrice(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDatePrice(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/date/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDateDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDateDuration(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/price/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRoutePriceDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRoutePriceDuration(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date/price/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDatePriceDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDatePriceDuration(filterMapper.toModel(filterDTO)));
    }


    //**************************************7***************************************************

    @PostMapping(path = "where/route/date/price/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDatePriceName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/date/duration/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDateDurationName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDateDurationName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/price/duration/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRoutePriceDurationName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRoutePriceDurationName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/date/price/duration/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereDatePriceDurationName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereDatePriceDurationName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/date/price/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceTransfer(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDatePriceTransfer(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/date/duration/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDateDurationTransfer(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDateDurationTransfer(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/price/duration/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRoutePriceDurationTransfer(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRoutePriceDurationTransfer(filterMapper.toModel(filterDTO)));
    }

    //**************************************8***************************************************

    @PostMapping(path = "where/route/date/price/duration", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDuration(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDatePriceDuration(filterMapper.toModel(filterDTO)));
    }

    //**************************************9***************************************************

    @PostMapping(path = "where/route/date/price/duration/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDatePriceDurationName(filterMapper.toModel(filterDTO)));
    }

    @PostMapping(path = "where/route/date/price/duration/transfer", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationTranfser(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDatePriceDurationTranfser(filterMapper.toModel(filterDTO)));
    }
    //**************************************10**************************************************

    @PostMapping(path = "where/route/date/price/duration/transfer/name", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationTranfserName(@RequestBody FilterDTO filterDTO) {
        return flightRouteMapperModif2.toDTO(filterFlightRouteService.findWhereRouteDatePriceDurationTranfserName(filterMapper.toModel(filterDTO)));
    }
}

