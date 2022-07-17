package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.AirCompanyDTOModif;
import org.example.mapper.modelsMapper.modif.AirCompanyMapperModif;
import org.example.service.interfaces.models.AirCompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/air/company")
public class AirCompayControllerModif {
    private final AirCompanyService airCompanyService;
    private final AirCompanyMapperModif airCompanyMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> readAll() {
        return airCompanyMapperModif.toDTO(airCompanyService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif readSingleId(@PathVariable("id") Long id) {
        return airCompanyMapperModif.toDTO(airCompanyService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> readAllById(@RequestBody List<Long> ids) {
        return airCompanyMapperModif.toDTO(airCompanyService.readAllByIds(ids));
    }

    @PostMapping(path = "create/all", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif create(@RequestBody AirCompanyDTOModif airCompanyDTOModif) {
        return airCompanyMapperModif.toDTO(airCompanyService.create(airCompanyMapperModif.toModel(airCompanyDTOModif)));
    }

    @PutMapping(path = "update/all", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif update(@RequestBody AirCompanyDTOModif airCompanyDTOModif) {
        return airCompanyMapperModif.toDTO(airCompanyService.update(airCompanyMapperModif.toModel(airCompanyDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif deleteById(@PathVariable("id") Long id) {
        return airCompanyMapperModif.toDTO(airCompanyService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return airCompanyMapperModif.toDTO(airCompanyService.deleteAllByIds(ids));
    }
}

