package org.example.service.models.seat;

import org.example.dto.models.SeatDTO;

import java.util.List;

public interface SeatService {
    List<SeatDTO> findSeatWhereAirPlaneId(Long idAirPlane);

    List<SeatDTO> readAll();

    SeatDTO readById(Long id);

    List<SeatDTO> readAllByIds(List<Long> ids);

    SeatDTO create(SeatDTO seatDTO);

    SeatDTO update(SeatDTO seatDTO);

    SeatDTO deleteById(Long id);

    List<SeatDTO> deleteAllByIds(List<Long> ids);
}
