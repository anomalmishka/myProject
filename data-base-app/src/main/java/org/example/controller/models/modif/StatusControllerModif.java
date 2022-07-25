package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.StatusDTOModif;
import org.example.mapper.models.modif.StatusMapperModif;
import org.example.service.models.api.StatusService;
import org.example.service.modif.api.StatusServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/status")
public class StatusControllerModif {
    private final StatusServiceModif statusServiceModif;
    private final StatusService statusService;
    private final StatusMapperModif statusMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<StatusDTOModif> readAll() {
        return statusMapperModif.toDTO(statusService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public StatusDTOModif readSingleId(@PathVariable("id") Long id) {
        return statusMapperModif.toDTO(statusService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<StatusDTOModif> readAllById(@RequestBody List<Long> ids) {
        return statusMapperModif.toDTO(statusService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public StatusDTOModif create(@RequestBody StatusDTOModif statusDTOModif) {
        return statusMapperModif.toDTO(statusServiceModif.create(statusMapperModif.toModel(statusDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public StatusDTOModif update(@RequestBody StatusDTOModif statusDTOModif) {
        return statusMapperModif.toDTO(statusServiceModif.update(statusMapperModif.toModel(statusDTOModif)));
    }
}

