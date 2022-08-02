package org.example.service.models.api;
import org.example.model.entity.AirPlane;
import java.util.List;
import java.util.Set;

public interface AirPlaneService {

    AirPlane create(AirPlane airPlane);

    List<AirPlane> readAll();

    AirPlane readById(Long id);

    List<AirPlane> readAllByIds(List<Long> ids);

    AirPlane deleteById(Long id);

    List<AirPlane> deleteAllByIds(List<Long> ids);

    AirPlane update(AirPlane airPlane);
}

