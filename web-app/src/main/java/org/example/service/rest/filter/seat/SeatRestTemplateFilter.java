package org.example.service.rest.filter.seat;

import org.example.dto.models.SeatDTO;

import java.util.List;

public interface SeatRestTemplateFilter {
    List<SeatDTO> findSeatWhereAirPlaneId(Long idAirPlane);
}
