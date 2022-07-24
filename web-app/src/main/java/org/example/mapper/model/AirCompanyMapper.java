package org.example.mapper.model;

import org.example.dto.models.AirCompanyDTO;
import org.example.model.obj.database.model.AirCompany;
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
                .priceLowcostIndex(airCompany.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompany.getPriceBuisnessIndex())
                .build();
    }

    public List<AirCompanyDTO> toDTO(List<AirCompany> airCompanyList) {
        return airCompanyList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirCompany> toModel(List<AirCompanyDTO> airCompanyDTOList) {
        return airCompanyDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirCompany toModel(AirCompanyDTO airCompanyDTO) {
        return AirCompany.builder()
                .id(airCompanyDTO.getId())
                .nameCompany(airCompanyDTO.getNameCompany())
                .countryLocation(airCompanyDTO.getCountryLocation())
                .priceLowcostIndex(airCompanyDTO.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompanyDTO.getPriceBuisnessIndex())
                .build();
    }
}
