package org.example.service.modif.api;

import org.example.model.Status;

import java.util.List;

public interface StatusService {

    Status create(Status status);

    List<Status> readAll();

    Status readById(Long id);

    List<Status> readAllByIds(List<Long> ids);

    Status deleteById(Long id);

    List<Status> deleteAllByIds(List<Long> ids);

    Status update(Status status);
}

