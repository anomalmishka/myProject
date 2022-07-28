package org.example.service.rest.models.airCompany;

import org.example.model.database.AirCompany;

import java.util.List;

public interface AirCompanyRestTemplateService {
    List<AirCompany> readAll();

    AirCompany readById(Long id);

    List<AirCompany> readAllByIds(List<Long> ids);

    AirCompany create(AirCompany airCompany);

    AirCompany update(AirCompany airCompany);

    AirCompany deleteById(Long id);

    List<AirCompany> deleteAllByIds(List<Long> ids);

}