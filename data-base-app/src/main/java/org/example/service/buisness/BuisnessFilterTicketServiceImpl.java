package org.example.service.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.TicketCustomDAO;
import org.example.dao.custom.UserCustomDAO;
import org.example.model.Ticket;
import org.example.model.User;
import org.example.service.api.buisness.BuisnessFilterTicketService;
import org.example.service.api.buisness.BuisnessFilterUserService;
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
