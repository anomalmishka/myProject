package org.example.service.models.api;
import org.example.model.entity.Ticket;
import java.util.List;

public interface TicketService {

    Ticket create(Ticket ticket);

    List<Ticket> readAll();

    Ticket readById(Long id);

    List<Ticket> readAllByIds(List<Long> ids);

    Ticket deleteById(Long id);

    List<Ticket> deleteAllByIds(List<Long> ids);

    Ticket update(Ticket ticket);
}

