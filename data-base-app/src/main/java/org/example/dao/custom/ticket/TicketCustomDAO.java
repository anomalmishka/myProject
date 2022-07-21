package org.example.dao.custom.ticket;

import java.util.List;

public interface TicketCustomDAO {
    List<Ticket> findAllTicketWherePassengerProfile(Long idPassengerProfile);
}
