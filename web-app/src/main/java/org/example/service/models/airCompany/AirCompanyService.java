package org.example.service.models.airCompany;

import org.example.dto.models.AirCompanyDTO;

import java.util.List;

public interface AirCompanyService {
    AirCompanyDTO create(AirCompanyDTO airCompanyDTO);
    List<AirCompanyDTO> readAll();
    AirCompanyDTO readById(Long id);
    List<AirCompanyDTO> readAllByIds(List<Long> ids);
    AirCompanyDTO deleteById(Long id);
    List<AirCompanyDTO> deleteAllByIds(List<Long> ids);
    AirCompanyDTO update(AirCompanyDTO airCompanyDTO);
}
