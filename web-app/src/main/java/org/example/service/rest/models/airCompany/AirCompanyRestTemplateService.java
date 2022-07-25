package org.example.service.rest.models.airCompany;

import org.example.model.database.AirCompany;

import java.util.List;

public interface AirCompanyRestTemplateService {
    AirCompany create(AirCompany airCompany);
    List<AirCompany> readAll();
    AirCompany readById(Long id);
    List<AirCompany> readAllByIds(List<Long> ids);
    AirCompany deleteById(Long id);
    List<AirCompany> deleteAllByIds(List<Long> ids);
    AirCompany update(AirCompany airCompany);
}
