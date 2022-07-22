package org.example.dao.models;

import org.example.model.entity.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDAO extends CrudRepository<Seat, Long> {
}
