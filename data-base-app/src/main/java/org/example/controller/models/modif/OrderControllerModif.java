package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.service.api.UserOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/order")
public class OrderControllerModif {
    private final UserOrderService userOrderService;
    private final UserOrderMapperModif userOrderMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> readAll() {
        return userOrderMapperModif.toDTO(userOrderService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif readSingleId(@PathVariable("id") Long id) {
        return userOrderMapperModif.toDTO(userOrderService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> readAllById(@RequestBody List<Long> ids) {
        return userOrderMapperModif.toDTO(userOrderService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif create(@RequestBody UserOrderDTOModif userOrderDTOModif) {
        return userOrderMapperModif.toDTO(userOrderService.create(userOrderMapperModif.toModel(userOrderDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif update(@RequestBody UserOrderDTOModif userOrderDTOModif) {
        return userOrderMapperModif.toDTO(userOrderService.update(userOrderMapperModif.toModel(userOrderDTOModif)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif deleteById(@PathVariable("id") Long id) {
        return userOrderMapperModif.toDTO(userOrderService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> deleteAllById(@RequestBody List<Long> ids) {
        return userOrderMapperModif.toDTO(userOrderService.deleteAllByIds(ids));
    }
}

