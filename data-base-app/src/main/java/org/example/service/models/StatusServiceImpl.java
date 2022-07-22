package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.StatusDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Status;
import org.example.service.api.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class StatusServiceImpl implements StatusService {
    private final StatusDAO statusDAO;

    @Override
    public Status create(Status status) {
        if (status.getStatus() != null) {
            return statusDAO.save(status);
        } else {
            throw new ErrorInvalidData("Status must not be null");
        }
    }

    @Override
    public List<Status> readAll() {
        return StreamSupport
                .stream(statusDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Status readById(Long id) {
        return statusDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<Status> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(statusDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Status deleteById(Long id) {
        Status deleteEntity = readById(id);
        statusDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<Status> deleteAllByIds(List<Long> ids) {
        List<Status> deleteEntities = readAllByIds(ids);
        statusDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public Status update(Status status) {
        if (status.getStatus() != null) {
            return statusDAO.save(status);
        } else {
            throw new ErrorInvalidData("Status must not be null");
        }
    }
}
