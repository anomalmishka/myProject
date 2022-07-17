package org.example.dao.custom;

import org.example.model.Ticket;

import java.util.List;

public interface TicketCustomDAO {
    List<Ticket> findAllTicketWhereUser(Long idUser);
}
