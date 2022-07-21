package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.OrderDTO;
import org.example.mapper.models.OrderMapper;
import org.example.service.api.UserOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user/order")
public class UserOrderController {
    private final UserOrderService userOrderService;
    private final OrderMapper orderMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<OrderDTO> readAll() {
        return orderMapper.toDTO(userOrderService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public OrderDTO readSingleId(@PathVariable("id") Long id) {
        return orderMapper.toDTO(userOrderService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<OrderDTO> readAllById(@RequestBody List<Long> ids) {
        return orderMapper.toDTO(userOrderService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return orderMapper.toDTO(userOrderService.create(orderMapper.toModel(orderDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        return orderMapper.toDTO(userOrderService.update(orderMapper.toModel(orderDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public OrderDTO deleteById(@PathVariable("id") Long id) {
        return orderMapper.toDTO(userOrderService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<OrderDTO> deleteAllById(@RequestBody List<Long> ids) {
        return orderMapper.toDTO(userOrderService.deleteAllByIds(ids));
    }
}

