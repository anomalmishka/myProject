package org.example.controller.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dto.api.AirCompanyDTOModif;
import org.example.mapper.api.AirCompanyMapperModif;
import org.example.service.api.buisness.BuisnessAirCompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/air/company")
public class BuisnessAirCompayController {
    private final BuisnessAirCompanyService buisnessAirCompanyService;
    private final AirCompanyMapperModif airCompanyMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> readAll() {
        return airCompanyMapperModif.toDTO(buisnessAirCompanyService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif readSingleId(@PathVariable("id") Long id) {
        return airCompanyMapperModif.toDTO(buisnessAirCompanyService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> readAllById(@RequestBody List<Long> ids) {
        return airCompanyMapperModif.toDTO(buisnessAirCompanyService.readAllByIds(ids));
    }

    @PostMapping(path = "create/all", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif create(@RequestBody AirCompanyDTOModif airCompanyDTOModif) {
        return airCompanyMapperModif.toDTO(buisnessAirCompanyService.createAirCompanyWithAll(airCompanyMapperModif.toModel(airCompanyDTOModif)));
    }

    @PutMapping(path = "update/all", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif update(@RequestBody AirCompanyDTOModif airCompanyDTOModif) {
        return airCompanyMapperModif.toDTO(buisnessAirCompanyService.updateAirCompanyWithAll(airCompanyMapperModif.toModel(airCompanyDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif deleteById(@PathVariable("id") Long id) {
        return airCompanyMapperModif.toDTO(buisnessAirCompanyService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return airCompanyMapperModif.toDTO(buisnessAirCompanyService.deleteAllByIds(ids));
    }
}

