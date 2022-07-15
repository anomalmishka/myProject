package org.example.service.api;

import org.example.model.AirCompany;

import java.util.List;

public interface BuisnessAirCompanyService {

    AirCompany createAirCompanyWithAll(AirCompany airCompany);

    List<AirCompany> readAll();

    AirCompany readById(Long id);

    List<AirCompany> readAllByIds(List<Long> ids);

    AirCompany deleteById(Long id);

    List<AirCompany> deleteAllByIds(List<Long> ids);

    AirCompany updateAirCompanyWithAll(AirCompany airCompany);

}

