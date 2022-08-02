package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.UserOrderDTO;
import org.example.mapper.models.UserOrderMapper;
import org.example.service.models.api.UserOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user/order")
public class UserOrderController {
    private final UserOrderService userOrderService;
    private final UserOrderMapper userOrderMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTO> readAll() {
        return userOrderMapper.toDTO(userOrderService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserOrderDTO readById(@PathVariable("id") Long id) {
        return userOrderMapper.toDTO(userOrderService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTO> readAllById(@RequestBody List<Long> ids) {
        return userOrderMapper.toDTO(userOrderService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserOrderDTO create(@RequestBody UserOrderDTO userOrderDTO) {
        return userOrderMapper.toDTO(userOrderService.create(userOrderMapper.toModel(userOrderDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserOrderDTO update(@RequestBody UserOrderDTO userOrderDTO) {
        return userOrderMapper.toDTO(userOrderService.update(userOrderMapper.toModel(userOrderDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserOrderDTO deleteById(@PathVariable("id") Long id) {
        return userOrderMapper.toDTO(userOrderService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTO> deleteAllById(@RequestBody List<Long> ids) {
        return userOrderMapper.toDTO(userOrderService.deleteAllByIds(ids));
    }
}

