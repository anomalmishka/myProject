package org.example.dao;

import org.example.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDAO extends CrudRepository<Ticket, Long> {
}
