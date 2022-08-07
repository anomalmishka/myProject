package org.example.service.modif.api;

import org.example.model.AirCompany;

import java.util.List;

public interface AirCompanyServiceModif {

    AirCompany create(AirCompany airCompany);

    List<AirCompany> readAll();

    AirCompany readById(Long id);

    List<AirCompany> readAllByIds(List<Long> ids);

    AirCompany deleteById(Long id);

    List<AirCompany> deleteAllByIds(List<Long> ids);

    AirCompany update(AirCompany airCompany);
}

