package org.example.mapper.page;

import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.AirPlaneDTO;
import org.example.dto.models.modif.AirCompanyDTOModif;
import org.example.dto.page.AirCompanyPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirCompanyMapperPage {
    public AirCompanyPage toDTO(AirCompanyDTO airCompanyDTO) {
        return AirCompanyPage.builder()
                .idAirCompany(airCompanyDTO.getId())
                .nameAirCompany(airCompanyDTO.getNameCompany())
                .countryLocationAirCompany(airCompanyDTO.getCountryLocation())
                .priceLowcostIndexAirCompany(airCompanyDTO.getPriceLowcostIndex())
                .priceBuisnessIndexAirCompany(airCompanyDTO.getPriceBuisnessIndex())
                .build();
    }

    public List<AirCompanyPage> toDTO(List<AirCompanyDTO> airCompanyDTOList) {
        return airCompanyDTOList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public AirCompanyPage toDTOModif(AirCompanyDTOModif airCompanyDTOModif) {
        List<AirPlaneDTO> airPlaneList = airCompanyDTOModif.getAirPlaneDTOList();
        return AirCompanyPage.builder()
                .idAirCompany(airCompanyDTOModif.getId())
                .nameAirCompany(airCompanyDTOModif.getNameCompany())
                .countryLocationAirCompany(airCompanyDTOModif.getCountryLocation())
                .priceLowcostIndexAirCompany(airCompanyDTOModif.getPriceLowcostIndex())
                .priceBuisnessIndexAirCompany(airCompanyDTOModif.getPriceBuisnessIndex())
                .idAirPlane(airPlaneList.stream().map(AirPlaneDTO::getId).collect(Collectors.toList()))
                .typeAirPlane(airPlaneList.stream().map(AirPlaneDTO::getType).collect(Collectors.toList()))
                .statusAirPlane(airPlaneList.stream().map(AirPlaneDTO::getStatus).collect(Collectors.toList()))
                .numberSeatLowcostAirPlane(airPlaneList.stream().map(AirPlaneDTO::getNumberSeatLowcost).collect(Collectors.toList()))
                .numberSeatBuisnessAirPlane(airPlaneList.stream().map(AirPlaneDTO::getNumberSeatBuisness).collect(Collectors.toList()))
                .pricePerKilometerAirPlane(airPlaneList.stream().map(AirPlaneDTO::getPricePerKilometer).collect(Collectors.toList()))
                .isActiveAirPlane(airPlaneList.stream().map(AirPlaneDTO::getIsActive).collect(Collectors.toList()))
                .build();
    }

    public List<AirCompanyPage> toDTOModif(List<AirCompanyDTOModif> airCompanyDTOModifList) {
        return airCompanyDTOModifList.stream().map(this::toDTOModif).collect(Collectors.toList());
    }
}
