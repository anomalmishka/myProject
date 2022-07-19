package org.example.service.filter.api;

import org.example.model.entity.Ticket;

import java.util.List;

public interface FilterTicketService {

    List<Ticket> findAllTicketWhereUser(Long idUser);

}

