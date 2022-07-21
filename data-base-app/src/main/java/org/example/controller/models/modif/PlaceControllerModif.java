package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.service.api.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/place")
public class PlaceControllerModif {
    private final SeatService seatService;
    private final SeatMapperModif seatMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<SeatDTOModif> readAll() {
        return seatMapperModif.toDTO(seatService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public SeatDTOModif readSingleId(@PathVariable("id") Long id) {
        return seatMapperModif.toDTO(seatService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<SeatDTOModif> readAllById(@RequestBody List<Long> ids) {
        return seatMapperModif.toDTO(seatService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public SeatDTOModif create(@RequestBody SeatDTOModif seatDTOModif) {
        return seatMapperModif.toDTO(seatService.create(seatMapperModif.toModel(seatDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public SeatDTOModif update(@RequestBody SeatDTOModif seatDTOModif) {
        return seatMapperModif.toDTO(seatService.update(seatMapperModif.toModel(seatDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public SeatDTOModif deleteById(@PathVariable("id") Long id) {
        return seatMapperModif.toDTO(seatService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<SeatDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return seatMapperModif.toDTO(seatService.deleteAllByIds(ids));
    }
}

