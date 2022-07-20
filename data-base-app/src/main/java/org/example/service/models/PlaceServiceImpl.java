package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.PlaceDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Seat;
import org.example.service.api.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceDAO placeDAO;

    @Override
    public Seat create(Seat seat) {
        if (seat.getPlace() != null) {
            return placeDAO.save(seat);
        } else {
            throw new ErrorInvalidData("Place must not be null");
        }
    }

    @Override
    public List<Seat> readAll() {
        return StreamSupport
                .stream(placeDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Seat readById(Long id) {
        return placeDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<Seat> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(placeDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Seat deleteById(Long id) {
        Seat deleteEntity = readById(id);
        placeDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<Seat> deleteAllByIds(List<Long> ids) {
        List<Seat> deleteEntities = readAllByIds(ids);
        placeDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public Seat update(Seat seat) {
        if (seat.getPlace() != null) {
            return placeDAO.save(seat);
        } else {
            throw new ErrorInvalidData("Place must not be null");
        }
    }
}
