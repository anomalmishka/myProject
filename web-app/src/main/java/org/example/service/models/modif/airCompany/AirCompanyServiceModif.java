package org.example.service.models.modif.airCompany;

import org.example.model.database.AirCompany;

import java.util.List;

public interface AirCompanyServiceModif {
    List<AirCompany> readAll();
    AirCompany readById(Long id);
    List<AirCompany> readAllByIds(List<Long> ids);
    AirCompany create(AirCompany airCompany);
    AirCompany update(AirCompany airCompany);
}
