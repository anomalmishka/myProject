package org.example.mapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirCompanyDTOModif;
import org.example.mapper.model.AirPlaneMapper;
import org.example.model.obj.database.modif.AirCompanyModif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirCompanyMapperModif {

    private final AirPlaneMapper airPlaneMapper;

    public AirCompanyDTOModif toDTO(AirCompanyModif airCompanyModif) {
        return AirCompanyDTOModif.builder()
                .id(airCompanyModif.getId())
                .nameCompany(airCompanyModif.getNameCompany())
                .countryLocation(airCompanyModif.getCountryLocation())
                .priceLowcostIndex(airCompanyModif.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompanyModif.getPriceBuisnessIndex())
                .airPlaneDTOList(airPlaneMapper.toDTO(airCompanyModif.getAirPlaneList()))
                .build();
    }

    public List<AirCompanyDTOModif> toDTO(List<AirCompanyModif> airCompanyModifList) {
        return airCompanyModifList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirCompanyModif> toModel(List<AirCompanyDTOModif> airCompanyDTOModifs) {
        return airCompanyDTOModifs.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirCompanyModif toModel(AirCompanyDTOModif airCompanyDTOModif) {
        return AirCompanyModif.builder()
                .id(airCompanyDTOModif.getId())
                .nameCompany(airCompanyDTOModif.getNameCompany())
                .countryLocation(airCompanyDTOModif.getCountryLocation())
                .priceLowcostIndex(airCompanyDTOModif.getPriceLowcostIndex())
                .priceBuisnessIndex(airCompanyDTOModif.getPriceBuisnessIndex())
                .airPlaneList(airPlaneMapper.toModel(airCompanyDTOModif.getAirPlaneDTOList()))
                .build();
    }
}
