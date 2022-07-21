package org.example.service.filter.api;

import java.util.List;

public interface FilterTicketService {

    List<Ticket> findAllTicketWherePassengerProfile(Long idPassengerProfile);

}

