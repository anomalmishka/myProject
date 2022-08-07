package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.FlightRouteDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.mapper.models.FlightRouteMapper;
import org.example.mapper.models.modif.FlightRouteMapperModif;
import org.example.service.modif.api.FlightRouteServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/flight/route")
public class FlightRouteControllerModif {
    private final FlightRouteServiceModif flightRouteServiceModif;
    private final FlightRouteMapperModif flightRouteMapperModif;
    private final FlightRouteMapper flightRouteMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> readAll() {
        return flightRouteMapperModif.toDTO(flightRouteServiceModif.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public FlightRouteDTOModif readById(@PathVariable("id") Long id) {
        return flightRouteMapperModif.toDTO(flightRouteServiceModif.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTOModif> readAllById(@RequestBody List<Long> ids) {
        return flightRouteMapperModif.toDTO(flightRouteServiceModif.readAllByIds(ids));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public FlightRouteDTO deleteById(@PathVariable("id") Long id) {
        return flightRouteMapper.toDTO(flightRouteServiceModif.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTO> deleteAllByIds(@RequestBody List<Long> ids) {
        return flightRouteMapper.toDTO(flightRouteServiceModif.deleteAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public FlightRouteDTOModif create(@RequestBody FlightRouteDTOModif flightRouteDTOModif) {
        return flightRouteMapperModif.toDTO(flightRouteServiceModif.create(flightRouteMapperModif.toModel(flightRouteDTOModif)));
    }
    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public FlightRouteDTOModif update(@RequestBody FlightRouteDTOModif flightRouteDTOModif) {
        return flightRouteMapperModif.toDTO(flightRouteServiceModif.update(flightRouteMapperModif.toModel(flightRouteDTOModif)));
    }
}

