package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.SeatDTOModif;
import org.example.mapper.modelsMapper.modif.SeatMapperModif;
import org.example.service.api.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/place")
public class PlaceControllerModif {
    private final PlaceService placeService;
    private final SeatMapperModif seatMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<SeatDTOModif> readAll() {
        return seatMapperModif.toDTO(placeService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public SeatDTOModif readSingleId(@PathVariable("id") Long id) {
        return seatMapperModif.toDTO(placeService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<SeatDTOModif> readAllById(@RequestBody List<Long> ids) {
        return seatMapperModif.toDTO(placeService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public SeatDTOModif create(@RequestBody SeatDTOModif seatDTOModif) {
        return seatMapperModif.toDTO(placeService.create(seatMapperModif.toModel(seatDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public SeatDTOModif update(@RequestBody SeatDTOModif seatDTOModif) {
        return seatMapperModif.toDTO(placeService.update(seatMapperModif.toModel(seatDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public SeatDTOModif deleteById(@PathVariable("id") Long id) {
        return seatMapperModif.toDTO(placeService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<SeatDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return seatMapperModif.toDTO(placeService.deleteAllByIds(ids));
    }
}

