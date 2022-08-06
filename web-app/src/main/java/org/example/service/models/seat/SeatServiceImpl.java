package org.example.service.models.seat;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.SeatDTO;
import org.example.service.rest.filter.seat.SeatRestTemplateFilter;
import org.example.service.rest.models.seat.SeatRestTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRestTemplateFilter seatRestTemplateFilter;
    private final SeatRestTemplateService seatRestTemplateService;


    @Override
    public List<SeatDTO> findSeatWhereAirPlaneId(Long idAirPlane) {
        return seatRestTemplateFilter.findSeatWhereAirPlaneId(idAirPlane);
    }

    @Override
    public List<SeatDTO> readAll() {
        return seatRestTemplateService.readAll();
    }

    @Override
    public SeatDTO readById(Long id) {
        return seatRestTemplateService.readById(id);
    }

    @Override
    public List<SeatDTO> readAllByIds(List<Long> ids) {
        return seatRestTemplateService.readAllByIds(ids);
    }

    @Override
    public SeatDTO create(SeatDTO seatDTO) {
        return seatRestTemplateService.create(seatDTO);
    }

    @Override
    public SeatDTO update(SeatDTO seatDTO) {
        return seatRestTemplateService.update(seatDTO);
    }

    @Override
    public SeatDTO deleteById(Long id) {
        return seatRestTemplateService.deleteById(id);
    }

    @Override
    public List<SeatDTO> deleteAllByIds(List<Long> ids) {
        return seatRestTemplateService.deleteAllByIds(ids);
    }
}
