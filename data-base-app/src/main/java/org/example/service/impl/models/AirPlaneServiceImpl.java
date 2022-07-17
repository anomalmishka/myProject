package org.example.service.impl.models;
import lombok.RequiredArgsConstructor;
import org.example.dao.models.AirPlaneDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirPlane;
import org.example.service.interfaces.models.AirPlaneService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class AirPlaneServiceImpl implements AirPlaneService {

    private final AirPlaneDAO airPlaneDAO;

    @Override
    public AirPlane create(AirPlane airPlane) {
        if (airPlane.getType() != null) {
            return airPlaneDAO.save(airPlane);
        } else {
            throw new ErrorInvalidData("Type must not be null");
        }
    }

    @Override
    public List<AirPlane> readAll() {
        return StreamSupport
                .stream(airPlaneDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public AirPlane readById(Long id) {
        return airPlaneDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<AirPlane> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(airPlaneDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public AirPlane deleteById(Long id) {
        AirPlane deleteEntity = readById(id);
        airPlaneDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<AirPlane> deleteAllByIds(List<Long> ids) {
        List<AirPlane> deleteEntities = readAllByIds(ids);
        airPlaneDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public AirPlane update(AirPlane airPlane) {
        if (airPlane.getType() != null) {
            return airPlaneDAO.save(airPlane);
        } else {
            throw new ErrorInvalidData("Type must not be null");
        }
    }
}
