package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AirCompanyDTO;
import org.example.dto.AirPlaneDTO;
import org.example.dto.api.AirCompanyDTOModif;
import org.example.dto.api.AirPlaneDTOModif;
import org.example.mapper.AirPlaneMapper;
import org.example.mapper.api.AirCompanyMapperModif;
import org.example.mapper.api.AirPlaneMapperModif;
import org.example.model.AirCompany;
import org.example.service.api.AirPlaneService;
import org.example.service.api.BuisnessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "buisness")
public class BuisnessController {
    private final BuisnessService buisnessService;
    private final AirCompanyMapperModif airCompanyMapperModif;


    @PostMapping(path = "create/air/plane", produces = "application/json", consumes = "application/json")
    public AirCompanyDTOModif create(@RequestBody AirCompanyDTOModif airCompanyDTOModif) {
        return airCompanyMapperModif.toDTO(buisnessService.createAirCompanyWithAll(airCompanyMapperModif.toModel(airCompanyDTOModif)));
    }

//    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
//    public List<AirPlaneDTO> readAll() {
//        return airPlaneMapper.toDTO(airPlaneService.readAll());
//    }
//
//    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
//    public AirPlaneDTO readSingleId(@PathVariable("id") Long id) {
//        return airPlaneMapper.toDTO(airPlaneService.readById(id));
//    }
//
//    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
//    public List<AirPlaneDTO> readAllById(@RequestBody List<Long> ids) {
//        return airPlaneMapper.toDTO(airPlaneService.readAllByIds(ids));
//    }
//
//    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
//    public AirPlaneDTO create(@RequestBody AirPlaneDTO airPlaneDTO) {
//        return airPlaneMapper.toDTO(airPlaneService.create(airPlaneMapper.toModel(airPlaneDTO)));
//    }
//
//    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
//    public AirPlaneDTO update(@RequestBody AirPlaneDTO airPlaneDTO) {
//        return airPlaneMapper.toDTO(airPlaneService.update(airPlaneMapper.toModel(airPlaneDTO)));
//    }
//
//    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
//    public AirPlaneDTO deleteById(@PathVariable("id") Long id) {
//        return airPlaneMapper.toDTO(airPlaneService.deleteById(id));
//    }
//
//    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
//    public List<AirPlaneDTO> deleteAllById(@RequestBody List<Long> ids) {
//        return airPlaneMapper.toDTO(airPlaneService.deleteAllByIds(ids));
//    }
}

