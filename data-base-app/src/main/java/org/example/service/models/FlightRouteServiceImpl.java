package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.crud.FlightRouteDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.FlightRoute;
import org.example.service.models.api.FlightRouteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceImpl implements FlightRouteService {
    private final FlightRouteDAO flightRouteDAO;

    @Override
    public FlightRoute create(FlightRoute flightRoute) {
        if (flightRoute.getRouteStart() != null) {
            return flightRouteDAO.save(flightRoute);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<FlightRoute> readAll() {
        return StreamSupport
                .stream(flightRouteDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public FlightRoute readById(Long id) {
        return flightRouteDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<FlightRoute> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(flightRouteDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public FlightRoute deleteById(Long id) {
        FlightRoute deleteEntity = flightRouteDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
        flightRouteDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<FlightRoute> deleteAllByIds(List<Long> ids) {
        List<FlightRoute> deleteEntities = readAllByIds(ids);
        flightRouteDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public FlightRoute update(FlightRoute flightRoute) {
        if (flightRoute.getRouteStart() != null) {
            return flightRouteDAO.save(flightRoute);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }
}
