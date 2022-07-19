package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.TicketDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Ticket;
import org.example.service.api.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDAO ticketDAO;

    @Override
    public Ticket create(Ticket ticket) {
        if (ticket.getIsActive() != null) {
            return ticketDAO.save(ticket);
        } else {
            throw new ErrorInvalidData("Act must not be null");
        }
    }

    @Override
    public List<Ticket> readAll() {
        return StreamSupport
                .stream(ticketDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Ticket readById(Long id) {
        return ticketDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<Ticket> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(ticketDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Ticket deleteById(Long id) {
        Ticket deleteEntity = readById(id);
        ticketDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<Ticket> deleteAllByIds(List<Long> ids) {
        List<Ticket> deleteEntities = readAllByIds(ids);
        ticketDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public Ticket update(Ticket ticket) {
        if (ticket.getIsActive() != null) {
            return ticketDAO.save(ticket);
        } else {
            throw new ErrorInvalidData("Act must not be null");
        }
    }
}
