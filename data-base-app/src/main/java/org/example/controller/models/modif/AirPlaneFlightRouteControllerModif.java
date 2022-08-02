package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.AirPlaneFlightRouteDTOModif;
import org.example.mapper.models.modif.AirPlaneFlightRouteMapperModif;
import org.example.service.models.modif.api.AirPlaneFlightRouteServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/air/plane/flight/route")
public class AirPlaneFlightRouteControllerModif {
    private final AirPlaneFlightRouteServiceModif airPlaneFlightRouteServiceModif;
    private final AirPlaneFlightRouteMapperModif airPlaneFlightRouteMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirPlaneFlightRouteDTOModif> readAll() {
        return airPlaneFlightRouteMapperModif.toDTO(airPlaneFlightRouteServiceModif.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTOModif readById(@PathVariable("id") Long id) {
        return airPlaneFlightRouteMapperModif.toDTO(airPlaneFlightRouteServiceModif.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneFlightRouteDTOModif> readAllById(@RequestBody List<Long> ids) {
        return airPlaneFlightRouteMapperModif.toDTO(airPlaneFlightRouteServiceModif.readAllByIds(ids));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTOModif deleteById(@PathVariable("id") Long id) {
        return airPlaneFlightRouteMapperModif.toDTO(airPlaneFlightRouteServiceModif.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneFlightRouteDTOModif> deleteAllByIds(@RequestBody List<Long> ids) {
        return airPlaneFlightRouteMapperModif.toDTO(airPlaneFlightRouteServiceModif.deleteAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTOModif create(@RequestBody AirPlaneFlightRouteDTOModif airPlaneFlightRouteDTOModif) {
        return airPlaneFlightRouteMapperModif.toDTO(airPlaneFlightRouteServiceModif.create(airPlaneFlightRouteMapperModif.toModel(airPlaneFlightRouteDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public AirPlaneFlightRouteDTOModif update(@RequestBody AirPlaneFlightRouteDTOModif airPlaneFlightRouteDTOModif) {
        return airPlaneFlightRouteMapperModif.toDTO(airPlaneFlightRouteServiceModif.update(airPlaneFlightRouteMapperModif.toModel(airPlaneFlightRouteDTOModif)));
    }
}

