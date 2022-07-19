package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.ticket.TicketCustomDAO;
import org.example.model.entity.Ticket;
import org.example.service.filter.api.FilterTicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterTicketServiceImpl implements FilterTicketService {

    private final TicketCustomDAO ticketCustomDAO;


    @Override
    public List<Ticket> findAllTicketWhereUser(Long idUser) {
        return ticketCustomDAO.findAllTicketWhereUser(idUser);
    }
}
