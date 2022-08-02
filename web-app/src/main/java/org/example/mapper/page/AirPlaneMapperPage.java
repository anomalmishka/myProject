
package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.AirPlaneDTOModif;
import org.example.dto.page.modelPage.AirPlanePage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperPage {
    private final SeatMapperPage seatMapperPage;
    private final AirCompanyMapperPage airCompanyMapperPage;

    public AirPlaneDTOModif toDTO(AirPlanePage airPlanePage) {
        return AirPlaneDTOModif.builder()
                .id(airPlanePage.getId())
                .type(airPlanePage.getType())
                .status(airPlanePage.getStatus())
                .numberSeatLowcost(airPlanePage.getNumberSeatLowcost())
                .numberSeatBuisness(airPlanePage.getNumberSeatBuisness())
                .isActive(airPlanePage.getIsActive())
                .airCompanyDTO(airCompanyMapperPage.toDTO(airPlanePage.getAirCompanyPage()))
                .seatDTOList(seatMapperPage.toDTO(airPlanePage.getSeatPageList()))
                .build();
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlanePage> airPlanePageList) {
        return Optional.ofNullable(airPlanePageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlanePage> toPage(List<AirPlaneDTOModif> airPlaneDTOModifList) {
        return Optional.ofNullable(airPlaneDTOModifList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public AirPlanePage toPage(AirPlaneDTOModif airPlaneDTOModif) {
        return AirPlanePage.builder()
                .id(airPlaneDTOModif.getId())
                .type(airPlaneDTOModif.getType())
                .status(airPlaneDTOModif.getStatus())
                .numberSeatLowcost(airPlaneDTOModif.getNumberSeatLowcost())
                .numberSeatBuisness(airPlaneDTOModif.getNumberSeatBuisness())
                .isActive(airPlaneDTOModif.getIsActive())
                .airCompanyPage(airCompanyMapperPage.toPage(airPlaneDTOModif.getAirCompanyDTO()))
                .seatPageList(seatMapperPage.toPage(airPlaneDTOModif.getSeatDTOList()))
                .build();
    }
}
