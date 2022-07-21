package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.mapper.models.modif.PassengerProfileMapperModif;
import org.example.service.api.PassengerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/passenger/profile")
public class PassengerProfileControllerModif {
    private final PassengerProfileService passengerProfileService;
    private final PassengerProfileMapperModif passengerProfileMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOModif> readAll() {
        return passengerProfileMapperModif.toDTO(passengerProfileService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif readSingleId(@PathVariable("id") Long id) {
        return passengerProfileMapperModif.toDTO(passengerProfileService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOModif> readAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapperModif.toDTO(passengerProfileService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif create(@RequestBody PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileMapperModif.toDTO(passengerProfileService.create(passengerProfileMapperModif.toModel(passengerProfileDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif update(@RequestBody PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileMapperModif.toDTO(passengerProfileService.update(passengerProfileMapperModif.toModel(passengerProfileDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif deleteById(@PathVariable("id") Long id) {
        return passengerProfileMapperModif.toDTO(passengerProfileService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapperModif.toDTO(passengerProfileService.deleteAllByIds(ids));
    }
}

