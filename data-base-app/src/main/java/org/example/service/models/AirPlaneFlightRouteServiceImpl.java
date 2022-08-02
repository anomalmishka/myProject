package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.AirPlaneFlightRouteDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirPlaneFlightRoute;
import org.example.service.models.api.AirPlaneFlightRouteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class AirPlaneFlightRouteServiceImpl implements AirPlaneFlightRouteService {

    private final AirPlaneFlightRouteDAO airPlaneFlightRouteDAO;

    @Override
    public AirPlaneFlightRoute create(AirPlaneFlightRoute airPlaneFlightRoute) {
        return airPlaneFlightRouteDAO.save(airPlaneFlightRoute);
    }

    @Override
    public List<AirPlaneFlightRoute> readAll() {
        return StreamSupport
                .stream(airPlaneFlightRouteDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public AirPlaneFlightRoute readById(Long id) {
        return airPlaneFlightRouteDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<AirPlaneFlightRoute> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(airPlaneFlightRouteDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public AirPlaneFlightRoute deleteById(Long id) {
        AirPlaneFlightRoute deleteEntity = airPlaneFlightRouteDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
        airPlaneFlightRouteDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<AirPlaneFlightRoute> deleteAllByIds(List<Long> ids) {
        List<AirPlaneFlightRoute> deleteEntities = readAllByIds(ids);
        airPlaneFlightRouteDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public AirPlaneFlightRoute update(AirPlaneFlightRoute airPlane) {
        if (airPlane.getId() != null) {
            return airPlaneFlightRouteDAO.save(airPlane);
        } else {
            throw new ErrorInvalidData("Id must not be null");
        }
    }
}
