package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.UserProfileDTO;
import org.example.mapper.models.UserProfileMapper;
import org.example.service.models.api.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user/profile")
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTO> readAll() {
        return userProfileMapper.toDTO(userProfileService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTO readSingleId(@PathVariable("id") Long id) {
        return userProfileMapper.toDTO(userProfileService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTO> readAllById(@RequestBody List<Long> ids) {
        return userProfileMapper.toDTO(userProfileService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserProfileDTO create(@RequestBody UserProfileDTO userProfileDTO) {
        return userProfileMapper.toDTO(userProfileService.create(userProfileMapper.toModel(userProfileDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserProfileDTO update(@RequestBody UserProfileDTO userProfileDTO) {
        return userProfileMapper.toDTO(userProfileService.update(userProfileMapper.toModel(userProfileDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTO deleteById(@PathVariable("id") Long id) {
        return userProfileMapper.toDTO(userProfileService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTO> deleteAllById(@RequestBody List<Long> ids) {
        return userProfileMapper.toDTO(userProfileService.deleteAllByIds(ids));
    }
}

