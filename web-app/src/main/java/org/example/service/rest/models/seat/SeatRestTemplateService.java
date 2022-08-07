package org.example.service.rest.models.seat;

import org.example.dto.models.SeatDTO;

import java.util.List;

public interface SeatRestTemplateService {
    List<SeatDTO> readAll();

    SeatDTO readById(Long id);

    List<SeatDTO> readAllByIds(List<Long> ids);

    SeatDTO create(SeatDTO seatDTO);

    SeatDTO update(SeatDTO seatDTO);

    SeatDTO deleteById(Long id);

    List<SeatDTO> deleteAllByIds(List<Long> ids);
}
