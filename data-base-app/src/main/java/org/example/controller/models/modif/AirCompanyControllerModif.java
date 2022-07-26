package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirCompanyDTOModif;
import org.example.mapper.models.modif.AirCompanyMapperModif;
import org.example.service.models.api.AirCompanyService;
import org.example.service.modif.api.AirCompanyServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/air/company")
public class AirCompanyControllerModif {
    private final AirCompanyService airCompanyService;
    private final AirCompanyServiceModif airCompanyServiceModif;
    private final AirCompanyMapperModif airCompanyMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> readAll() {
        return airCompanyMapperModif.toDTO(airCompanyService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif readById(@PathVariable("id") Long id) {
        return airCompanyMapperModif.toDTO(airCompanyService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> readAllById(@RequestBody List<Long> ids) {
        return airCompanyMapperModif.toDTO(airCompanyService.readAllByIds(ids));
    }

    @PutMapping(path = "create", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif create(@RequestBody AirCompanyDTOModif airCompanyDTOModif) {
        return airCompanyMapperModif.toDTO(airCompanyServiceModif.create(airCompanyMapperModif.toModel(airCompanyDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif update(@RequestBody AirCompanyDTOModif airCompanyDTOModif) {
        return airCompanyMapperModif.toDTO(airCompanyServiceModif.update(airCompanyMapperModif.toModel(airCompanyDTOModif)));
    }
}

