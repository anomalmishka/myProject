package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.mapper.models.modif.UserProfileMapperModif;
import org.example.service.modif.api.UserProfileServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/user/profile")
public class UserProfileControllerModif {
    private final UserProfileServiceModif userProfileServiceModif;
    private final UserProfileMapperModif userProfileMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOModif> readAll() {
        return userProfileMapperModif.toDTO(userProfileServiceModif.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif readById(@PathVariable("id") Long id) {
        return userProfileMapperModif.toDTO(userProfileServiceModif.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOModif> readAllById(@RequestBody List<Long> ids) {
        return userProfileMapperModif.toDTO(userProfileServiceModif.readAllByIds(ids));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif deleteById(@PathVariable("id") Long id) {
        return userProfileMapperModif.toDTO(userProfileServiceModif.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOModif> deleteAllByIds(@RequestBody List<Long> ids) {
        return userProfileMapperModif.toDTO(userProfileServiceModif.deleteAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif create(@RequestBody UserProfileDTOModif userDTOModif) {
        return userProfileMapperModif.toDTO(userProfileServiceModif.create(userProfileMapperModif.toModel(userDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif update(@RequestBody UserProfileDTOModif userDTOModif) {
        return userProfileMapperModif.toDTO(userProfileServiceModif.update(userProfileMapperModif.toModel(userDTOModif)));
    }
}

