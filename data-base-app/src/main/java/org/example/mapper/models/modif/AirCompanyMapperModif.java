package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirCompanyDTOModif;
import org.example.mapper.models.AirPlaneMapper;
import org.example.mapper.models.FlightRouteMapper;
import org.example.model.entity.AirCompany;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class AirCompanyMapperModif {

    private final AirPlaneMapper airPlaneMapper;
    private final FlightRouteMapper flightRouteMapper;

    public AirCompanyDTOModif toDTO(AirCompany airCompany) {
        return AirCompanyDTOModif.builder()
                .id(airCompany.getId())
                .nameCompany(airCompany.getNameCompany())
                .countryLocation(airCompany.getCountryLocation())
                .airPlaneDTOList(airPlaneMapper.toDTO(airCompany.getAirPlaneList()))
                .flightRouteDTOList(flightRouteMapper.toDTO(airCompany.getFlightRouteList()))
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
                .airPlaneList(airPlaneMapper.toModel(airCompanyDTOModif.getAirPlaneDTOList()))
                .flightRouteList(flightRouteMapper.toModel(airCompanyDTOModif.getFlightRouteDTOList()))
                .build();
    }
}
