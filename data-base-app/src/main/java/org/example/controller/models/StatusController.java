package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.StatusDTO;
import org.example.mapper.models.StatusMapper;
import org.example.service.api.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "status")
public class StatusController {
    private final StatusService statusService;
    private final StatusMapper statusMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<StatusDTO> readAll() {
        return statusMapper.toDTO(statusService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public StatusDTO readSingleId(@PathVariable("id") Long id) {
        return statusMapper.toDTO(statusService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<StatusDTO> readAllById(@RequestBody List<Long> ids) {
        return statusMapper.toDTO(statusService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public StatusDTO create(@RequestBody StatusDTO statusDTO) {
        return statusMapper.toDTO(statusService.create(statusMapper.toModel(statusDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public StatusDTO update(@RequestBody StatusDTO statusDTO) {
        return statusMapper.toDTO(statusService.update(statusMapper.toModel(statusDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public StatusDTO deleteById(@PathVariable("id") Long id) {
        return statusMapper.toDTO(statusService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<StatusDTO> deleteAllById(@RequestBody List<Long> ids) {
        return statusMapper.toDTO(statusService.deleteAllByIds(ids));
    }
}

