package org.example.mapper.ladder;

import lombok.RequiredArgsConstructor;
import org.example.dto.ladder.AirCompanyDTOLadder;
import org.example.model.entity.AirCompany;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirCompanyMapperLadder {

    private final AirPlaneMapperLadder airPlaneMapperLadder;

    public AirCompanyDTOLadder toDTO(AirCompany airCompany) {
        return AirCompanyDTOLadder.builder()
                .id(airCompany.getId())
                .nameCompany(airCompany.getNameCompany())
                .countryLocation(airCompany.getCountryLocation())
                .priceLowcostIndex(airCompany.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompany.getPriceBuisnessIndex())
                .airPlaneDTOLadderList(airPlaneMapperLadder.toDTO(airCompany.getAirPlaneList()))
                .build();
    }

    public List<AirCompanyDTOLadder> toDTO(List<AirCompany> airCompanyList) {
        return airCompanyList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirCompany> toModel(List<AirCompanyDTOLadder> airCompanyDTOLadderList) {
        return airCompanyDTOLadderList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirCompany toModel(AirCompanyDTOLadder airCompanyDTOLadder) {
        return AirCompany.builder()
                .id(airCompanyDTOLadder.getId())
                .nameCompany(airCompanyDTOLadder.getNameCompany())
                .countryLocation(airCompanyDTOLadder.getCountryLocation())
                .priceLowcostIndex(airCompanyDTOLadder.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompanyDTOLadder.getPriceBuisnessIndex())
                .airPlaneList(airPlaneMapperLadder.toModel(airCompanyDTOLadder.getAirPlaneDTOLadderList()))
                .build();
    }
}
