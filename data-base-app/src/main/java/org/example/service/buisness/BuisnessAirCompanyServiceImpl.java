package org.example.service.buisness;

import lombok.RequiredArgsConstructor;
import org.example.model.AirCompany;
import org.example.service.api.AirCompanyService;
import org.example.service.api.buisness.BuisnessAirCompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuisnessAirCompanyServiceImpl implements BuisnessAirCompanyService {

    private final AirCompanyService airCompanyService;

    @Override
    public AirCompany createAirCompanyWithAll(AirCompany airCompany) {
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
        return airCompanyService.deleteById(id);
    }

    @Override
    public List<AirCompany> deleteAllByIds(List<Long> ids) {
        return airCompanyService.deleteAllByIds(ids);
    }

    @Override
    public AirCompany updateAirCompanyWithAll(AirCompany airCompany) {
        return airCompanyService.update(airCompany);
    }

}
