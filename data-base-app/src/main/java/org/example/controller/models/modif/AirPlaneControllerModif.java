package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.mapper.modelsMapper.modif.AirPlaneMapperModif;
import org.example.service.api.AirPlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/air/plane")
public class AirPlaneControllerModif {
    private final AirPlaneService airPlaneService;
    private final AirPlaneMapperModif airPlaneMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> readAll() {
        return airPlaneMapperModif.toDTO(airPlaneService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif readSingleId(@PathVariable("id") Long id) {
        return airPlaneMapperModif.toDTO(airPlaneService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> readAllById(@RequestBody List<Long> ids) {
        return airPlaneMapperModif.toDTO(airPlaneService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif create(@RequestBody AirPlaneDTOModif airPlaneDTOModif) {
        return airPlaneMapperModif.toDTO(airPlaneService.create(airPlaneMapperModif.toModel(airPlaneDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif update(@RequestBody AirPlaneDTOModif airPlaneDTOModif) {
        return airPlaneMapperModif.toDTO(airPlaneService.update(airPlaneMapperModif.toModel(airPlaneDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneDTOModif deleteById(@PathVariable("id") Long id) {
        return airPlaneMapperModif.toDTO(airPlaneService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return airPlaneMapperModif.toDTO(airPlaneService.deleteAllByIds(ids));
    }
}

