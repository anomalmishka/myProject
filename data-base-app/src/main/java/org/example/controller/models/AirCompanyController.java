package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.AirCompanyDTO;
import org.example.mapper.models.AirCompanyMapper;
import org.example.service.models.api.AirCompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "air/company")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;
    private final AirCompanyMapper airCompanyMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTO> readAll() {
        return airCompanyMapper.toDTO(airCompanyService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirCompanyDTO readById(@PathVariable("id") Long id) {
        return airCompanyMapper.toDTO(airCompanyService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTO> readAllById(@RequestBody List<Long> ids) {
        return airCompanyMapper.toDTO(airCompanyService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public AirCompanyDTO create(@RequestBody AirCompanyDTO airCompanyDTO) {
        return airCompanyMapper.toDTO(airCompanyService.create(airCompanyMapper.toModel(airCompanyDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public AirCompanyDTO update(@RequestBody AirCompanyDTO airCompanyDTO) {
        return airCompanyMapper.toDTO(airCompanyService.update(airCompanyMapper.toModel(airCompanyDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirCompanyDTO deleteById(@PathVariable("id") Long id) {
        return airCompanyMapper.toDTO(airCompanyService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirCompanyDTO> deleteAllById(@RequestBody List<Long> ids) {
        return airCompanyMapper.toDTO(airCompanyService.deleteAllByIds(ids));
    }
}

