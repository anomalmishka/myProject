package org.example.service.rest.modif;

import org.example.model.database.AirCompany;

import java.util.List;

public interface AirCompanyRestTemplateServiceModif {
    AirCompany create(AirCompany airCompany);

    List<AirCompany> readAll();

    AirCompany readById(Long id);

    List<AirCompany> readAllByIds(List<Long> ids);

    AirCompany update(AirCompany airCompany);
}
