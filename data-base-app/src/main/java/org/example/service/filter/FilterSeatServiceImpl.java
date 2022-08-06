package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.seat.SeatCustomDAO;
import org.example.model.Seat;
import org.example.service.filter.api.FilterSeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterSeatServiceImpl implements FilterSeatService {

    private final SeatCustomDAO seatCustomDAO;

    @Override
    public List<Seat> findSeatWhereAirPlaneId(Long id) {
        return seatCustomDAO.findSeatWhereAirPlaneId(id);
    }
}
