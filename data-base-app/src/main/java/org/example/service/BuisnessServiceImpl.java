package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.AirCompany;
import org.example.service.api.AirCompanyService;
import org.example.service.api.BuisnessService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BuisnessServiceImpl implements BuisnessService {

    private final AirCompanyService airCompanyService;

    @Override
    public AirCompany createAirCompanyWithAll(AirCompany airCompany) {
        return airCompanyService.create(airCompany);
    }

    @Override
    public AirCompany updateAirCompanyWithAll(AirCompany airCompany) {
        return airCompanyService.update(airCompany);
    }
}
