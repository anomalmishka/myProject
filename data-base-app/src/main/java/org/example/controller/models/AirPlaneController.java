package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirPlaneDTO;
import org.example.mapper.models.AirPlaneMapper;
import org.example.service.models.api.AirPlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "air/plane")
public class AirPlaneController {
    private final AirPlaneService airPlaneService;
    private final AirPlaneMapper airPlaneMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTO> readAll() {
        return airPlaneMapper.toDTO(airPlaneService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneDTO readById(@PathVariable("id") Long id) {
        return airPlaneMapper.toDTO(airPlaneService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTO> readAllById(@RequestBody List<Long> ids) {
        return airPlaneMapper.toDTO(airPlaneService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public AirPlaneDTO create(@RequestBody AirPlaneDTO airPlaneDTO) {
        return airPlaneMapper.toDTO(airPlaneService.create(airPlaneMapper.toModel(airPlaneDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public AirPlaneDTO update(@RequestBody AirPlaneDTO airPlaneDTO) {
        return airPlaneMapper.toDTO(airPlaneService.update(airPlaneMapper.toModel(airPlaneDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public AirPlaneDTO deleteById(@PathVariable("id") Long id) {
        return airPlaneMapper.toDTO(airPlaneService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<AirPlaneDTO> deleteAllById(@RequestBody List<Long> ids) {
        return airPlaneMapper.toDTO(airPlaneService.deleteAllByIds(ids));
    }
}

