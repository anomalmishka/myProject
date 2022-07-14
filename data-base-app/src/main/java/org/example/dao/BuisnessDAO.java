package org.example.dao;

import org.example.model.Ticket;

import java.util.List;

public interface BuisnessDAO {
    List<Ticket> findFromRoute();
}
