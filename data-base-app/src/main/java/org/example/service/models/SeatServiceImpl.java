package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.SeatDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Seat;
import org.example.service.api.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {
    private final SeatDAO seatDAO;

    @Override
    public Seat create(Seat seat) {
        if (seat.getPlace() != null) {
            return seatDAO.save(seat);
        } else {
            throw new ErrorInvalidData("Place must not be null");
        }
    }

    @Override
    public List<Seat> readAll() {
        return StreamSupport
                .stream(seatDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Seat readById(Long id) {
        return seatDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<Seat> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(seatDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Seat deleteById(Long id) {
        Seat deleteEntity = readById(id);
        seatDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<Seat> deleteAllByIds(List<Long> ids) {
        List<Seat> deleteEntities = readAllByIds(ids);
        seatDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public Seat update(Seat seat) {
        if (seat.getPlace() != null) {
            return seatDAO.save(seat);
        } else {
            throw new ErrorInvalidData("Place must not be null");
        }
    }
}
