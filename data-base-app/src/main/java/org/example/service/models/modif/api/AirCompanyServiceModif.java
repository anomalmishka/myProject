package org.example.service.models.modif.api;

import org.example.model.entity.AirCompany;

import java.util.List;

public interface AirCompanyServiceModif {
    AirCompany create(AirCompany airCompany);
    AirCompany update(AirCompany airCompany);
}

