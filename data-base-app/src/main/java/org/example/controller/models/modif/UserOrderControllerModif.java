package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.mapper.models.modif.UserOrderMapperModif;
import org.example.service.models.api.UserOrderService;
import org.example.service.modif.api.UserOrderServiceModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/user/order")
public class UserOrderControllerModif {
    private final UserOrderService userOrderService;
    private final UserOrderServiceModif userOrderServiceModif;
    private final UserOrderMapperModif userOrderMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> readAll() {
        return userOrderMapperModif.toDTO(userOrderService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif readSingleId(@PathVariable("id") Long id) {
        return userOrderMapperModif.toDTO(userOrderService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> readAllById(@RequestBody List<Long> ids) {
        return userOrderMapperModif.toDTO(userOrderService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif create(@RequestBody UserOrderDTOModif userOrderDTOModif) {
        return userOrderMapperModif.toDTO(userOrderServiceModif.create(userOrderMapperModif.toModel(userOrderDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif update(@RequestBody UserOrderDTOModif userOrderDTOModif) {
        return userOrderMapperModif.toDTO(userOrderServiceModif.update(userOrderMapperModif.toModel(userOrderDTOModif)));
    }
}

