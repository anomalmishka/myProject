package org.example.service.impl.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.ticket.TicketCustomDAO;
import org.example.model.entity.Ticket;
import org.example.service.interfaces.buisness.BuisnessFilterTicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuisnessFilterTicketServiceImpl implements BuisnessFilterTicketService {

    private final TicketCustomDAO ticketCustomDAO;


    @Override
    public List<Ticket> findAllTicketWhereUser(Long idUser) {
        return ticketCustomDAO.findAllTicketWhereUser(idUser);
    }
}
