package org.example.service.models.airCompany;

import lombok.RequiredArgsConstructor;
import org.example.model.database.AirCompany;
import org.example.service.rest.models.airCompany.AirCompanyRestTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRestTemplateService airCompanyRestTemplateService;

    @Override
    public AirCompany create(AirCompany airCompany) {
        return airCompanyRestTemplateService.create(airCompany);
    }

    @Override
    public List<AirCompany> readAll() {
        return airCompanyRestTemplateService.readAll();
    }

    @Override
    public AirCompany readById(Long id) {
        return airCompanyRestTemplateService.readById(id);
    }

    @Override
    public List<AirCompany> readAllByIds(List<Long> ids) {
        return airCompanyRestTemplateService.readAllByIds(ids);
    }

    @Override
    public AirCompany deleteById(Long id) {
        return airCompanyRestTemplateService.deleteById(id);
    }

    @Override
    public List<AirCompany> deleteAllByIds(List<Long> ids) {
        return airCompanyRestTemplateService.deleteAllByIds(ids);
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        return airCompanyRestTemplateService.update(airCompany);
    }
}
