package org.example.mapper.modelsMapper;


import org.example.dto.modelsDTO.TicketDTO;
import org.example.model.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketMapper {
    public TicketDTO toDTO(Ticket ticket) {
        return TicketDTO.builder()
                .id(ticket.getId())
                .passengerSeat(ticket.getPassengerSeat())
                .isEmptySeat(ticket.getIsEmptySeat())
                .isActive(ticket.getIsActive())
                .build();
    }

    public List<TicketDTO> toDTO(List<Ticket> tickets) {
        return tickets.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<Ticket> toModel(List<TicketDTO> ticketDTOS) {
        return ticketDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Ticket toModel(TicketDTO ticketDTO) {
        return Ticket.builder()
                .id(ticketDTO.getId())
                .passengerSeat(ticketDTO.getPassengerSeat())
                .isEmptySeat(ticketDTO.getIsEmptySeat())
                .isActive(ticketDTO.getIsActive())
                .build();
    }
}
