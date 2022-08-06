package org.example.dao.crud;

import org.example.model.AirCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyDAO extends CrudRepository<AirCompany, Long> {
}
