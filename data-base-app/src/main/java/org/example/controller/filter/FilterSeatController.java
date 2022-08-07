package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.SeatDTO;
import org.example.mapper.models.SeatMapper;
import org.example.service.filter.api.FilterSeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/seat")
public class FilterSeatController {
    private final FilterSeatService filterSeatService;
    private final SeatMapper seatMapper;

    @GetMapping(path = "where/air/plane/{idAirPlane}", produces = "application/json", consumes = "application/json")
    public List<SeatDTO> findSeatWhereAirPlaneId(@PathVariable("idAirPlane") Long idAirPlane) {
        return seatMapper.toDTO(filterSeatService.findSeatWhereAirPlaneId(idAirPlane));
    }
}

