package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.TicketDTO;
import org.example.mapper.TicketMapper;
import org.example.service.api.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "ticket")
public class TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<TicketDTO> readAll() {
        return ticketMapper.toDTO(ticketService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public TicketDTO readSingleId(@PathVariable("id") Long id) {
        return ticketMapper.toDTO(ticketService.readById(id));
    }

    @GetMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<TicketDTO> readAllById(@RequestBody List<Long> ids) {
        return ticketMapper.toDTO(ticketService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public TicketDTO create(@RequestBody TicketDTO ticketDTO) {
        return ticketMapper.toDTO(ticketService.create(ticketMapper.toModel(ticketDTO)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public TicketDTO update(@RequestBody TicketDTO ticketDTO) {
        return ticketMapper.toDTO(ticketService.update(ticketMapper.toModel(ticketDTO)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public TicketDTO deleteById(@PathVariable("id") Long id) {
        return ticketMapper.toDTO(ticketService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<TicketDTO> deleteAllById(@RequestBody List<Long> ids) {
        return ticketMapper.toDTO(ticketService.deleteAllByIds(ids));
    }
}

