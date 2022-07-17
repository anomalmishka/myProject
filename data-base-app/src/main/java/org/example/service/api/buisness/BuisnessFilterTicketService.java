package org.example.service.api.buisness;

import org.example.model.Ticket;

import java.util.List;

public interface BuisnessFilterTicketService {

    List<Ticket> findAllTicketWhereUser(Long idUser);

}

