package org.example.dao.models;

import org.example.model.entity.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDAO extends CrudRepository<Status, Long> {
}
