package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.PassengerProfileDTO;
import org.example.mapper.models.PassengerProfileMapper;
import org.example.service.models.api.PassengerProfileService;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "passenger/profile")
public class PassengerProfileController implements Serializable {
    private final PassengerProfileService passengerProfileService;
    private final PassengerProfileMapper passengerProfileMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTO> readAll() {
        return passengerProfileMapper.toDTO(passengerProfileService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTO readById(@PathVariable("id") Long id) {
        return passengerProfileMapper.toDTO(passengerProfileService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTO> readAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapper.toDTO(passengerProfileService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTO create(@RequestBody PassengerProfileDTO passengerProfileDTO) {
        return passengerProfileMapper.toDTO(passengerProfileService.create(passengerProfileMapper.toModel(passengerProfileDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTO update(@RequestBody PassengerProfileDTO passengerProfileDTO) {
        return passengerProfileMapper.toDTO(passengerProfileService.update(passengerProfileMapper.toModel(passengerProfileDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTO deleteById(@PathVariable("id") Long id) {
        return passengerProfileMapper.toDTO(passengerProfileService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTO> deleteAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapper.toDTO(passengerProfileService.deleteAllByIds(ids));
    }
}

