package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.mapper.modelsMapper.modif.FlightRouteMapperModif;
import org.example.service.api.FlightRouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/flight/route")
public class FlightRouteControllerModif {
    private final FlightRouteService flightRouteService;
    private final FlightRouteMapperModif flightRouteMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> readAll() {
        return flightRouteMapperModif.toDTO(flightRouteService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public FlightRouteDTOModif readSingleId(@PathVariable("id") Long id) {
        return flightRouteMapperModif.toDTO(flightRouteService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> readAllById(@RequestBody List<Long> ids) {
        return flightRouteMapperModif.toDTO(flightRouteService.readAllByIds(ids));
    }

    @PostMapping(path = "create/all", produces = "application/json", consumes = "application/json")
    public FlightRouteDTOModif create(@RequestBody FlightRouteDTOModif flightRouteDTOModif) {
        return flightRouteMapperModif.toDTO(flightRouteService.create(flightRouteMapperModif.toModel(flightRouteDTOModif)));
    }

    @PutMapping(path = "update/all", produces = "application/json", consumes = "application/json")
    public FlightRouteDTOModif update(@RequestBody FlightRouteDTOModif flightRouteDTOModif) {
        return flightRouteMapperModif.toDTO(flightRouteService.update(flightRouteMapperModif.toModel(flightRouteDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public FlightRouteDTOModif deleteById(@PathVariable("id") Long id) {
        return flightRouteMapperModif.toDTO(flightRouteService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return flightRouteMapperModif.toDTO(flightRouteService.deleteAllByIds(ids));
    }
}

