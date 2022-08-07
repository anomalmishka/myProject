package org.example.service.rest.models.airCompany;

import org.example.dto.models.AirCompanyDTO;

import java.util.List;

public interface AirCompanyRestTemplateService {
    List<AirCompanyDTO> readAll();

    AirCompanyDTO readById(Long id);

    List<AirCompanyDTO> readAllByIds(List<Long> ids);

    AirCompanyDTO create(AirCompanyDTO airCompany);

    AirCompanyDTO update(AirCompanyDTO airCompany);

    AirCompanyDTO deleteById(Long id);

    List<AirCompanyDTO> deleteAllByIds(List<Long> ids);

}
