package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.mapper.models.modif.AirPlaneMapperModif;
import org.example.service.modif.api.AirPlaneServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/air/plane")
public class AirPlaneControllerModif {
    private final AirPlaneServiceModif airPlaneServiceModif;
    private final AirPlaneMapperModif airPlaneMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> readAll() {
        return airPlaneMapperModif.toDTO(airPlaneServiceModif.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif readById(@PathVariable("id") Long id) {
        return airPlaneMapperModif.toDTO(airPlaneServiceModif.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> readAllById(@RequestBody List<Long> ids) {
        return airPlaneMapperModif.toDTO(airPlaneServiceModif.readAllByIds(ids));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif deleteById(@PathVariable("id") Long id) {
        return airPlaneMapperModif.toDTO(airPlaneServiceModif.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> deleteAllByIds(@RequestBody List<Long> ids) {
        return airPlaneMapperModif.toDTO(airPlaneServiceModif.deleteAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif create(@RequestBody AirPlaneDTOModif airPlaneDTOModif) {
        return airPlaneMapperModif.toDTO(airPlaneServiceModif.create(airPlaneMapperModif.toModel(airPlaneDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif update(@RequestBody AirPlaneDTOModif airPlaneDTOModif) {
        return airPlaneMapperModif.toDTO(airPlaneServiceModif.update(airPlaneMapperModif.toModel(airPlaneDTOModif)));
    }
}

