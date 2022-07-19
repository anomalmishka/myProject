package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.TicketDTO;
import org.example.mapper.modelsMapper.TicketMapper;
import org.example.service.filter.api.FilterTicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/ticket")
public class FilterTicketController {
    private final FilterTicketService filterTicketService;
    private final TicketMapper ticketMapper;

    @GetMapping(path = "find/ticket/where/user/{id}/", produces = "application/json", consumes = "application/json")
    public List<TicketDTO> findAllTicketWhereUser(@PathVariable("id") Long id) {
        return ticketMapper.toDTO(filterTicketService.findAllTicketWhereUser(id));
    }
}

