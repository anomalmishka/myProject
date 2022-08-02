package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.UserOrderDTOModif;
import org.example.mapper.models.modif.UserOrderMapperModif;
import org.example.service.models.modif.UserOrderServiceImplModif;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/user/order")
public class UserOrderControllerModif {
    private final UserOrderServiceImplModif userOrderServiceImplModif;
    private final UserOrderMapperModif userOrderMapperModif;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> readAll() {
        return userOrderMapperModif.toDTO(userOrderServiceImplModif.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif readById(@PathVariable("id") Long id) {
        return userOrderMapperModif.toDTO(userOrderServiceImplModif.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> readAllById(@RequestBody List<Long> ids) {
        return userOrderMapperModif.toDTO(userOrderServiceImplModif.readAllByIds(ids));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif deleteById(@PathVariable("id") Long id) {
        return userOrderMapperModif.toDTO(userOrderServiceImplModif.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserOrderDTOModif> deleteAllByIds(@RequestBody List<Long> ids) {
        return userOrderMapperModif.toDTO(userOrderServiceImplModif.deleteAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif create(@RequestBody UserOrderDTOModif userOrderDTOModif) {
        return userOrderMapperModif.toDTO(userOrderServiceImplModif.create(userOrderMapperModif.toModel(userOrderDTOModif)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserOrderDTOModif update(@RequestBody UserOrderDTOModif userOrderDTOModif) {
        return userOrderMapperModif.toDTO(userOrderServiceImplModif.update(userOrderMapperModif.toModel(userOrderDTOModif)));
    }
}

