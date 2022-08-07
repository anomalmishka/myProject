package org.example.service.models.api;

import org.example.model.Seat;

import java.util.List;

public interface SeatService {

    Seat create(Seat seat);

    List<Seat> readAll();

    Seat readById(Long id);

    List<Seat> readAllByIds(List<Long> ids);

    Seat deleteById(Long id);

    List<Seat> deleteAllByIds(List<Long> ids);

    Seat update(Seat seat);
}

