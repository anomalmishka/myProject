package org.example.dao.crud;

import org.example.model.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDAO extends CrudRepository<Seat, Long> {
}
