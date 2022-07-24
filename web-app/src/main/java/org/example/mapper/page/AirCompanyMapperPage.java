package org.example.mapper.page;

import org.example.dto.models.AirPlaneDTO;
import org.example.dto.models.modif.AirCompanyDTOModif;
import org.example.dto.models.page.AirCompanyDTOModifPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirCompanyMapperPage {
    public AirCompanyDTOModifPage toPageDTO(AirCompanyDTOModif airCompanyDTOModif) {
        List<AirPlaneDTO> airPlaneList = airCompanyDTOModif.getAirPlaneDTOList();
        return AirCompanyDTOModifPage.builder()
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

    public List<AirCompanyDTOModifPage> toPageDTO(List<AirCompanyDTOModif> airCompanyDTOModifList) {
        return airCompanyDTOModifList.stream().map(this::toPageDTO).collect(Collectors.toList());
    }
}
