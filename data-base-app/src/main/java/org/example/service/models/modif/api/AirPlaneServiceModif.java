package org.example.service.models.modif.api;

import org.example.model.entity.AirPlane;

import java.util.List;

public interface AirPlaneServiceModif {

    AirPlane create(AirPlane airPlane);

    List<AirPlane> readAll();

    AirPlane readById(Long id);

    List<AirPlane> readAllByIds(List<Long> ids);

    AirPlane deleteById(Long id);

    List<AirPlane> deleteAllByIds(List<Long> ids);

    AirPlane update(AirPlane airPlane);
}

