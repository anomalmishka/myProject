package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.FlightRouteDTO;
import org.example.mapper.models.FlightRouteMapper;
import org.example.service.models.api.FlightRouteService;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "flight/route")
public class FlightRouteController implements Serializable {
    private final FlightRouteService flightRouteService;
    private final FlightRouteMapper flightRouteMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTO> readAll() {
        return flightRouteMapper.toDTO(flightRouteService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public FlightRouteDTO readById(@PathVariable("id") Long id) {
        return flightRouteMapper.toDTO(flightRouteService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTO> readAllById(@RequestBody List<Long> ids) {
        return flightRouteMapper.toDTO(flightRouteService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public FlightRouteDTO create(@RequestBody FlightRouteDTO flightRouteDTO) {
        return flightRouteMapper.toDTO(flightRouteService.create(flightRouteMapper.toModel(flightRouteDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public FlightRouteDTO update(@RequestBody FlightRouteDTO flightRouteDTO) {
        return flightRouteMapper.toDTO(flightRouteService.update(flightRouteMapper.toModel(flightRouteDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public FlightRouteDTO deleteById(@PathVariable("id") Long id) {
        return flightRouteMapper.toDTO(flightRouteService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<FlightRouteDTO> deleteAllById(@RequestBody List<Long> ids) {
        return flightRouteMapper.toDTO(flightRouteService.deleteAllByIds(ids));
    }
}

