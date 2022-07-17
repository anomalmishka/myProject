package org.example.service.interfaces.buisness;

import org.example.model.entity.Ticket;

import java.util.List;

public interface BuisnessFilterTicketService {

    List<Ticket> findAllTicketWhereUser(Long idUser);

}

