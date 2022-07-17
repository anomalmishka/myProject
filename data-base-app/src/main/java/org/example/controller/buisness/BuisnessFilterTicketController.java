package org.example.controller.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.TicketDTO;
import org.example.mapper.modelsMapper.TicketMapper;
import org.example.service.interfaces.buisness.BuisnessFilterTicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/ticket")
public class BuisnessFilterTicketController {
    private final BuisnessFilterTicketService buisnessFilterTicketService;
    private final TicketMapper ticketMapper;

    @GetMapping(path = "find/ticket/where/user/{id}/", produces = "application/json", consumes = "application/json")
    public List<TicketDTO> findAllTicketWhereUser(@PathVariable("id") Long id) {
        return ticketMapper.toDTO(buisnessFilterTicketService.findAllTicketWhereUser(id));
    }
}

