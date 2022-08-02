package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.AirPlaneFlightRouteDTO;
import org.example.mapper.models.AirPlaneFlightRouteMapper;
import org.example.service.models.api.AirPlaneFlightRouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "air/plane/flight/route")
public class AirPlaneFligthRouteController {
    private final AirPlaneFlightRouteService airPlaneFlightRouteService;
    private final AirPlaneFlightRouteMapper airPlaneFlightRouteMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirPlaneFlightRouteDTO> readAll() {
        return airPlaneFlightRouteMapper.toDTO(airPlaneFlightRouteService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTO readById(@PathVariable("id") Long id) {
        return airPlaneFlightRouteMapper.toDTO(airPlaneFlightRouteService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneFlightRouteDTO> readAllById(@RequestBody List<Long> ids) {
        return airPlaneFlightRouteMapper.toDTO(airPlaneFlightRouteService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTO create(@RequestBody AirPlaneFlightRouteDTO airPlaneFlightRouteDTO) {
        return airPlaneFlightRouteMapper.toDTO(airPlaneFlightRouteService.create(airPlaneFlightRouteMapper.toModel(airPlaneFlightRouteDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTO update(@RequestBody AirPlaneFlightRouteDTO airPlaneFlightRouteDTO) {
        return airPlaneFlightRouteMapper.toDTO(airPlaneFlightRouteService.update(airPlaneFlightRouteMapper.toModel(airPlaneFlightRouteDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTO deleteById(@PathVariable("id") Long id) {
        return airPlaneFlightRouteMapper.toDTO(airPlaneFlightRouteService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneFlightRouteDTO> deleteAllById(@RequestBody List<Long> ids) {
        return airPlaneFlightRouteMapper.toDTO(airPlaneFlightRouteService.deleteAllByIds(ids));
    }
}

