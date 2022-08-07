package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.mapper.models.modif.PassengerProfileMapperModif;
import org.example.service.modif.api.PassengerProfileServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/passenger/profile")
public class PassengerProfileControllerModif {
    private final PassengerProfileServiceModif passengerProfileServiceModif;
    private final PassengerProfileMapperModif passengerProfileMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOModif> readAll() {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif readById(@PathVariable("id") Long id) {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOModif> readAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.readAllByIds(ids));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif deleteById(@PathVariable("id") Long id) {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOModif> deleteAllByIds(@RequestBody List<Long> ids) {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.deleteAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif create(@RequestBody PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.create(passengerProfileMapperModif.toModel(passengerProfileDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif update(@RequestBody PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.update(passengerProfileMapperModif.toModel(passengerProfileDTOModif)));
    }
}

