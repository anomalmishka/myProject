package org.example.dao;

import org.example.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyDAO extends CrudRepository<AirCompany, Long> {
}
