package org.example.controller.models;
import lombok.RequiredArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.mapper.models.BankCardMapper;
import org.example.service.models.api.BankCardService;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "bank/card")
public class BankCardController implements Serializable {
    private final BankCardService bankCardService;
    private final BankCardMapper bankCardMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<BankCardDTO> readAll() {
        return bankCardMapper.toDTO(bankCardService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public BankCardDTO readById(@PathVariable("id") Long id) {
        return bankCardMapper.toDTO(bankCardService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<BankCardDTO> readAllById(@RequestBody List<Long> ids) {
        return bankCardMapper.toDTO(bankCardService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public BankCardDTO create(@RequestBody BankCardDTO bankCardDTO) {
        return bankCardMapper.toDTO(bankCardService.create(bankCardMapper.toModel(bankCardDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public BankCardDTO update(@RequestBody BankCardDTO bankCardDTO) {
        return bankCardMapper.toDTO(bankCardService.update(bankCardMapper.toModel(bankCardDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public BankCardDTO deleteById(@PathVariable("id") Long id) {
        return bankCardMapper.toDTO(bankCardService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<BankCardDTO> deleteAllById(@RequestBody List<Long> ids) {
        return bankCardMapper.toDTO(bankCardService.deleteAllByIds(ids));
    }
}

