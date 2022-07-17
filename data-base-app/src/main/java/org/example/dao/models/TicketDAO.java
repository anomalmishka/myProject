package org.example.dao.models;

import org.example.model.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDAO extends CrudRepository<Ticket, Long> {
}
