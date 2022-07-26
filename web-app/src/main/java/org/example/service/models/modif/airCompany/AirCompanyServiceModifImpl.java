package org.example.service.models.modif.airCompany;

import lombok.RequiredArgsConstructor;
import org.example.model.database.AirCompany;
import org.example.service.rest.modif.AirCompanyRestTemplateServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirCompanyServiceModifImpl implements AirCompanyServiceModif {

    private final AirCompanyRestTemplateServiceModif airCompanyRestTemplateServiceModif;

    @Override
    public AirCompany create(AirCompany airCompany) {
        return airCompanyRestTemplateServiceModif.create(airCompany);
    }

    @Override
    public List<AirCompany> readAll() {
        return airCompanyRestTemplateServiceModif.readAll();
    }

    @Override
    public AirCompany readById(Long id) {
        return airCompanyRestTemplateServiceModif.readById(id);
    }

    @Override
    public List<AirCompany> readAllByIds(List<Long> ids) {
        return airCompanyRestTemplateServiceModif.readAllByIds(ids);
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        return airCompanyRestTemplateServiceModif.update(airCompany);
    }
}
