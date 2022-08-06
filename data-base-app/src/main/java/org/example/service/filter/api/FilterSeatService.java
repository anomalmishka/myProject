package org.example.service.filter.api;

import org.example.model.Seat;

import java.util.List;

public interface FilterSeatService {
    List<Seat> findSeatWhereAirPlaneId(Long id);
}

