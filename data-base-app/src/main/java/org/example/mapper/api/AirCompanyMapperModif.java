package org.example.mapper.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.api.AirCompanyDTOModif;
import org.example.model.AirCompany;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class AirCompanyMapperModif {

    private final AirPlaneMapperModif airPlaneMapperModif;

    public AirCompanyDTOModif toDTO(AirCompany airCompany) {
        return AirCompanyDTOModif.builder()
                .id(airCompany.getId())
                .nameCompany(airCompany.getNameCompany())
                .countryLocation(airCompany.getCountryLocation())
                .airPlaneDTOModifs(airPlaneMapperModif.toDTO(airCompany.getAirPlanes()))
                .build();
    }

    public List<AirCompanyDTOModif> toDTO(List<AirCompany> airCompanies) {
        return airCompanies.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<AirCompany> toModel(List<AirCompanyDTOModif> airCompanyDTOModifs) {
        return airCompanyDTOModifs.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirCompany toModel(AirCompanyDTOModif airCompanyDTOModif) {
        return AirCompany.builder()
                .id(airCompanyDTOModif.getId())
                .nameCompany(airCompanyDTOModif.getNameCompany())
                .countryLocation(airCompanyDTOModif.getCountryLocation())
                .airPlanes(airPlaneMapperModif.toModel(airCompanyDTOModif.getAirPlaneDTOModifs()))
                .build();
    }
}
