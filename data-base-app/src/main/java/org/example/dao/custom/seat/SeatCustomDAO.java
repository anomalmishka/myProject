package org.example.dao.custom.seat;

import org.example.model.Seat;

import java.util.List;

public interface SeatCustomDAO {
    List<Seat> findSeatWhereAirPlaneId(Long id);
}
