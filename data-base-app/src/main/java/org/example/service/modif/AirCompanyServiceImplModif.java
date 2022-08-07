package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.model.AirCompany;
import org.example.model.AirPlane;
import org.example.service.models.api.AirCompanyService;
import org.example.service.modif.api.AirCompanyServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirCompanyServiceImplModif implements AirCompanyServiceModif {

    private final AirCompanyService airCompanyService;
    private final AirPlaneServiceImplModif airPlaneServiceImplModif;

    @Override
    public AirCompany create(AirCompany airCompany) {
        return airCompanyService.create(airCompany);
    }

    @Override
    public List<AirCompany> readAll() {
        return airCompanyService.readAll();
    }

    @Override
    public AirCompany readById(Long id) {
        return airCompanyService.readById(id);
    }

    @Override
    public List<AirCompany> readAllByIds(List<Long> ids) {
        return airCompanyService.readAllByIds(ids);
    }

    @Override
    public AirCompany deleteById(Long id) {
        return airCompanyService.readById(id);
    }

    @Override
    public List<AirCompany> deleteAllByIds(List<Long> ids) {
        return airCompanyService.readAllByIds(ids);
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        return airCompanyService.update(airCompany);
    }
}
