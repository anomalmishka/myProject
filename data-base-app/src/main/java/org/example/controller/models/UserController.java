package org.example.controller.models;
import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.UserDTO;
import org.example.mapper.modelsMapper.UserMapper;
import org.example.service.interfaces.models.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserDTO> readAll() {
        return userMapper.toDTO(userService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserDTO readSingleId(@PathVariable("id") Long id) {
        return userMapper.toDTO(userService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserDTO> readAllById(@RequestBody List<Long> ids) {
        return userMapper.toDTO(userService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userMapper.toDTO(userService.create(userMapper.toModel(userDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userMapper.toDTO(userService.update(userMapper.toModel(userDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserDTO deleteById(@PathVariable("id") Long id) {
        return userMapper.toDTO(userService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserDTO> deleteAllById(@RequestBody List<Long> ids) {
        return userMapper.toDTO(userService.deleteAllByIds(ids));
    }
}

