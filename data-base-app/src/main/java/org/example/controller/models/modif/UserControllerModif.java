package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.UserDTOModif;
import org.example.mapper.modelsMapper.modif.UserMapperModif;
import org.example.service.interfaces.models.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/user")
public class UserControllerModif {
    private final UserService userService;
    private final UserMapperModif userMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserDTOModif> readAll() {
        return userMapperModif.toDTO(userService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserDTOModif readSingleId(@PathVariable("id") Long id) {
        return userMapperModif.toDTO(userService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserDTOModif> readAllById(@RequestBody List<Long> ids) {
        return userMapperModif.toDTO(userService.readAllByIds(ids));
    }

    @PostMapping(path = "create/all", produces = "application/json", consumes = "application/json")
    public UserDTOModif create(@RequestBody UserDTOModif userDTOModif) {
        return userMapperModif.toDTO(userService.create(userMapperModif.toModel(userDTOModif)));
    }

    @PutMapping(path = "update/all", produces = "application/json", consumes = "application/json")
    public UserDTOModif update(@RequestBody UserDTOModif userDTOModif) {
        return userMapperModif.toDTO(userService.update(userMapperModif.toModel(userDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserDTOModif deleteById(@PathVariable("id") Long id) {
        return userMapperModif.toDTO(userService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return userMapperModif.toDTO(userService.deleteAllByIds(ids));
    }
}

