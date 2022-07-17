package org.example.dao.models;

import org.example.model.entity.BankCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardDAO extends CrudRepository<BankCard, Long> {
}
