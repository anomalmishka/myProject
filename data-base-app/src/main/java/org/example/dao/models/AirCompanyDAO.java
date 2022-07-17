package org.example.dao.models;

import org.example.model.entity.AirCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyDAO extends CrudRepository<AirCompany, Long> {
}
