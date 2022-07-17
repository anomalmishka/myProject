package org.example.mapper.modelsMapper;


import org.example.dto.modelsDTO.AirCompanyDTO;
import org.example.model.entity.AirCompany;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirCompanyMapper {
    public AirCompanyDTO toDTO(AirCompany airCompany) {
        return AirCompanyDTO.builder()
                .id(airCompany.getId())
                .nameCompany(airCompany.getNameCompany())
                .countryLocation(airCompany.getCountryLocation())
                .build();
    }

    public List<AirCompanyDTO> toDTO(List<AirCompany> airCompanies) {
        return airCompanies.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<AirCompany> toModel(List<AirCompanyDTO> airCompanyDTOS) {
        return airCompanyDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirCompany toModel(AirCompanyDTO airCompanyDTO) {
        return AirCompany.builder()
                .id(airCompanyDTO.getId())
                .nameCompany(airCompanyDTO.getNameCompany())
                .countryLocation(airCompanyDTO.getCountryLocation())
                .build();
    }
}
