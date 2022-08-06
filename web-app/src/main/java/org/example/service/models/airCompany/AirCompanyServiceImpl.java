package org.example.service.models.airCompany;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.service.rest.models.airCompany.AirCompanyRestTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRestTemplateService airCompanyRestTemplateService;

    @Override
    public AirCompanyDTO create(AirCompanyDTO airCompanyDTO) {
        return airCompanyRestTemplateService.create(airCompanyDTO);
    }

    @Override
    public List<AirCompanyDTO> readAll() {
        return airCompanyRestTemplateService.readAll();
    }

    @Override
    public AirCompanyDTO readById(Long id) {
        return airCompanyRestTemplateService.readById(id);
    }

    @Override
    public List<AirCompanyDTO> readAllByIds(List<Long> ids) {
        return airCompanyRestTemplateService.readAllByIds(ids);
    }

    @Override
    public AirCompanyDTO deleteById(Long id) {
        return airCompanyRestTemplateService.deleteById(id);
    }

    @Override
    public List<AirCompanyDTO> deleteAllByIds(List<Long> ids) {
        return airCompanyRestTemplateService.deleteAllByIds(ids);
    }

    @Override
    public AirCompanyDTO update(AirCompanyDTO airCompanyDTO) {
        return airCompanyRestTemplateService.update(airCompanyDTO);
    }
}
