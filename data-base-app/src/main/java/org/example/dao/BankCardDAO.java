package org.example.dao;

import org.example.model.BankCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardDAO extends CrudRepository<BankCard, Long> {
}
