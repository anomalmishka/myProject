package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.mapper.models.modif.PassengerProfileMapperModif;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.modif.api.PassengerProfileServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/passenger/profile")
public class PassengerProfileControllerModif {
    private final PassengerProfileServiceModif passengerProfileServiceModif;
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
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.create(passengerProfileMapperModif.toModel(passengerProfileDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOModif update(@RequestBody PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileMapperModif.toDTO(passengerProfileServiceModif.update(passengerProfileMapperModif.toModel(passengerProfileDTOModif)));
    }
}

