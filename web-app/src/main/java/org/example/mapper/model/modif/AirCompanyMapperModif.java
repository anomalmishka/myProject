package org.example.mapper.model.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirCompanyDTOModif;
import org.example.mapper.model.AirPlaneMapper;
import org.example.model.database.AirCompany;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirCompanyMapperModif {

    private final AirPlaneMapper airPlaneMapper;

    public AirCompanyDTOModif toDTO(AirCompany airCompany) {
        return AirCompanyDTOModif.builder()
                .id(airCompany.getId())
                .nameCompany(airCompany.getNameCompany())
                .countryLocation(airCompany.getCountryLocation())
                .priceLowcostIndex(airCompany.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompany.getPriceBuisnessIndex())
                .airPlaneDTOList(airPlaneMapper.toDTO(airCompany.getAirPlaneList()))
                .build();
    }

    public List<AirCompanyDTOModif> toDTO(List<AirCompany> airCompanyList) {
        return airCompanyList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirCompany> toModel(List<AirCompanyDTOModif> airCompanyDTOModifs) {
        return airCompanyDTOModifs.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirCompany toModel(AirCompanyDTOModif airCompanyDTOModif) {
        return AirCompany.builder()
                .id(airCompanyDTOModif.getId())
                .nameCompany(airCompanyDTOModif.getNameCompany())
                .countryLocation(airCompanyDTOModif.getCountryLocation())
                .priceLowcostIndex(airCompanyDTOModif.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompanyDTOModif.getPriceBuisnessIndex())
                .airPlaneList(airPlaneMapper.toModel(airCompanyDTOModif.getAirPlaneDTOList()))
                .build();
    }
}