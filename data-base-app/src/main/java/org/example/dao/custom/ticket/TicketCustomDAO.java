package org.example.dao.custom.ticket;

import org.example.model.entity.Ticket;

import java.util.List;

public interface TicketCustomDAO {
    List<Ticket> findAllTicketWhereUser(Long idUser);
}
