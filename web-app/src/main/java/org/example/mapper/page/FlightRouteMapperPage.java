package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.example.dto.page.modelPage.FlightRoutePage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperPage {
    private final AirPlaneFlightRouteMapperPage airPlaneFlightRouteMapperPage;

    public FlightRouteDTOModif2 toDTO(FlightRoutePage flightRoutePage) {
        return FlightRouteDTOModif2.builder()
                .id(flightRoutePage.getId())
                .routeStart(flightRoutePage.getRouteStart())
                .routeEnd(flightRoutePage.getRouteEnd())
                .distance(flightRoutePage.getDistance())
                .flightDateStart(flightRoutePage.getFlightDateStart())
                .flightDateEnd(flightRoutePage.getFlightDateEnd())
                .price(flightRoutePage.getPrice())
                .isActive(flightRoutePage.getIsActive())
                .airPlaneFlightRouteDTOModif2List(airPlaneFlightRouteMapperPage
                        .toDTO(flightRoutePage.getAirPlaneFlightRoutePageList()))
                .build();
    }

    public List<FlightRouteDTOModif2> toDTO(List<FlightRoutePage> flightRoutePageList) {
        return Optional.ofNullable(flightRoutePageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }


    public List<FlightRoutePage> toPage(List<FlightRouteDTOModif2> flightRouteDTOModif2List) {
        return Optional.ofNullable(flightRouteDTOModif2List)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public FlightRoutePage toPage(FlightRouteDTOModif2 flightRouteDTOModif2) {
        return FlightRoutePage.builder()
                .id(flightRouteDTOModif2.getId())
                .routeStart(flightRouteDTOModif2.getRouteStart())
                .routeEnd(flightRouteDTOModif2.getRouteEnd())
                .distance(flightRouteDTOModif2.getDistance())
                .flightDateStart(flightRouteDTOModif2.getFlightDateStart())
                .flightDateEnd(flightRouteDTOModif2.getFlightDateEnd())
                .price(flightRouteDTOModif2.getPrice())
                .isActive(flightRouteDTOModif2.getIsActive())
                .airPlaneFlightRoutePageList(airPlaneFlightRouteMapperPage
                                .toPage(flightRouteDTOModif2.getAirPlaneFlightRouteDTOModif2List()))
                .build();
    }
}