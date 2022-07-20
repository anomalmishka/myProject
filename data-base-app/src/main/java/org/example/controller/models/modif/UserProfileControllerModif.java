package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.mapper.modelsMapper.modif.UserProfileMapperModif;
import org.example.service.api.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/user/profile")
public class UserProfileControllerModif {
    private final UserProfileService userProfileService;
    private final UserProfileMapperModif userProfileMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOModif> readAll() {
        return userProfileMapperModif.toDTO(userProfileService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif readSingleId(@PathVariable("id") Long id) {
        return userProfileMapperModif.toDTO(userProfileService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOModif> readAllById(@RequestBody List<Long> ids) {
        return userProfileMapperModif.toDTO(userProfileService.readAllByIds(ids));
    }

    @PostMapping(path = "create/all", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif create(@RequestBody UserProfileDTOModif userDTOModif) {
        return userProfileMapperModif.toDTO(userProfileService.create(userProfileMapperModif.toModel(userDTOModif)));
    }

    @PutMapping(path = "update/all", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif update(@RequestBody UserProfileDTOModif userDTOModif) {
        return userProfileMapperModif.toDTO(userProfileService.update(userProfileMapperModif.toModel(userDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif deleteById(@PathVariable("id") Long id) {
        return userProfileMapperModif.toDTO(userProfileService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return userProfileMapperModif.toDTO(userProfileService.deleteAllByIds(ids));
    }
}

