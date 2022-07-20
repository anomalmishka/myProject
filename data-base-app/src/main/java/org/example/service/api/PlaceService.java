package org.example.service.api;

import org.example.model.entity.Seat;

import java.util.List;

public interface PlaceService {

    Seat create(Seat seat);

    List<Seat> readAll();

    Seat readById(Long id);

    List<Seat> readAllByIds(List<Long> ids);

    Seat deleteById(Long id);

    List<Seat> deleteAllByIds(List<Long> ids);

    Seat update(Seat seat);
}

