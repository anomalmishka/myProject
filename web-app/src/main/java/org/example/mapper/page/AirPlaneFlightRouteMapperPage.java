package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.AirPlaneFlightRouteDTOModif2;
import org.example.dto.page.modelPage.AirPlaneFlightRoutePage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneFlightRouteMapperPage {
    private final AirPlaneMapperPage airPlaneMapperPage;

    public AirPlaneFlightRouteDTOModif2 toDTO(AirPlaneFlightRoutePage airPlaneFlightRoutePage) {
        return AirPlaneFlightRouteDTOModif2.builder()
                .id(airPlaneFlightRoutePage.getId())
                .airPlaneDTOModif(airPlaneMapperPage.toDTO(airPlaneFlightRoutePage.getAirPlanePage()))
                .build();
    }

    public List<AirPlaneFlightRouteDTOModif2> toDTO(List<AirPlaneFlightRoutePage> airPlaneFlightRoutePageList) {
        return Optional.ofNullable(airPlaneFlightRoutePageList)
                .map(airPlaneFlightRouteDTOModif2s -> airPlaneFlightRoutePageList
                        .stream().map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlaneFlightRoutePage> toPage(List<AirPlaneFlightRouteDTOModif2> airPlaneFlightRouteDTOModif2List) {
        return Optional.ofNullable(airPlaneFlightRouteDTOModif2List)
                .map(airPlaneFlightRouteDTOModif2s -> airPlaneFlightRouteDTOModif2List
                        .stream().map(this::toPage).collect(Collectors.toList())).orElse(null);
    }
    public AirPlaneFlightRoutePage toPage(AirPlaneFlightRouteDTOModif2 airPlaneFlightRouteDTOModif2) {
        return AirPlaneFlightRoutePage.builder()
                .id(airPlaneFlightRouteDTOModif2.getId())
                .airPlanePage(airPlaneMapperPage.toPage(airPlaneFlightRouteDTOModif2.getAirPlaneDTOModif()))
                .build();
    }
}
