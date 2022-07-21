package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.SeatDTO;
import org.example.mapper.models.SeatMapper;
import org.example.service.api.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "seat")
public class SeatController {
    private final SeatService seatService;
    private final SeatMapper seatMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<SeatDTO> readAll() {
        return seatMapper.toDTO(seatService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public SeatDTO readSingleId(@PathVariable("id") Long id) {
        return seatMapper.toDTO(seatService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<SeatDTO> readAllById(@RequestBody List<Long> ids) {
        return seatMapper.toDTO(seatService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public SeatDTO create(@RequestBody SeatDTO seatDTO) {
        return seatMapper.toDTO(seatService.create(seatMapper.toModel(seatDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public SeatDTO update(@RequestBody SeatDTO seatDTO) {
        return seatMapper.toDTO(seatService.update(seatMapper.toModel(seatDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public SeatDTO deleteById(@PathVariable("id") Long id) {
        return seatMapper.toDTO(seatService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<SeatDTO> deleteAllById(@RequestBody List<Long> ids) {
        return seatMapper.toDTO(seatService.deleteAllByIds(ids));
    }
}

