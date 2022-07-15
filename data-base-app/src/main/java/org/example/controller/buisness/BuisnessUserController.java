package org.example.controller.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dto.api.AirCompanyDTOModif;
import org.example.dto.api.UserDTOModif;
import org.example.mapper.api.UserMapperModif;
import org.example.service.api.BuisnessAirCompanyService;
import org.example.service.api.BuisnessUserService;
import org.example.service.api.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/user")
public class BuisnessUserController {
    private final BuisnessUserService buisnessUserService;
    private final UserMapperModif userMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserDTOModif> readAll() {
        return userMapperModif.toDTO(buisnessUserService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserDTOModif readSingleId(@PathVariable("id") Long id) {
        return userMapperModif.toDTO(buisnessUserService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserDTOModif> readAllById(@RequestBody List<Long> ids) {
        return userMapperModif.toDTO(buisnessUserService.readAllByIds(ids));
    }

    @PostMapping(path = "create/all", produces = "application/json", consumes = "application/json")
    public UserDTOModif create(@RequestBody UserDTOModif userDTOModif) {
        return userMapperModif.toDTO(buisnessUserService.createUserWithAll(userMapperModif.toModel(userDTOModif)));
    }

    @PutMapping(path = "update/all", produces = "application/json", consumes = "application/json")
    public UserDTOModif update(@RequestBody UserDTOModif userDTOModif) {
        return userMapperModif.toDTO(buisnessUserService.updateUserWithAll(userMapperModif.toModel(userDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserDTOModif deleteById(@PathVariable("id") Long id) {
        return userMapperModif.toDTO(buisnessUserService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return userMapperModif.toDTO(buisnessUserService.deleteAllByIds(ids));
    }
}

