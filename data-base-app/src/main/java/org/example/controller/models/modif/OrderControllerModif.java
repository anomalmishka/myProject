package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.OrderDTOModif;
import org.example.mapper.modelsMapper.modif.OrderMapperModif;
import org.example.service.api.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/order")
public class OrderControllerModif {
    private final OrderService orderService;
    private final OrderMapperModif orderMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<OrderDTOModif> readAll() {
        return orderMapperModif.toDTO(orderService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public OrderDTOModif readSingleId(@PathVariable("id") Long id) {
        return orderMapperModif.toDTO(orderService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<OrderDTOModif> readAllById(@RequestBody List<Long> ids) {
        return orderMapperModif.toDTO(orderService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public OrderDTOModif create(@RequestBody OrderDTOModif orderDTOModif) {
        return orderMapperModif.toDTO(orderService.create(orderMapperModif.toModel(orderDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public OrderDTOModif update(@RequestBody OrderDTOModif orderDTOModif) {
        return orderMapperModif.toDTO(orderService.update(orderMapperModif.toModel(orderDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public OrderDTOModif deleteById(@PathVariable("id") Long id) {
        return orderMapperModif.toDTO(orderService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<OrderDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return orderMapperModif.toDTO(orderService.deleteAllByIds(ids));
    }
}

