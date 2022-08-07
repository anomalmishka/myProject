package org.example.mapper.page;

import lombok.*;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.dto.models.modif.AirPlaneFlightRouteDTOModif;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.dto.page.ViewingFlightInformationPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ViewingFlightInformationMapperPage {
    private final ModelMapper modelMapper;
    private final AirPlaneFlightRouteMapperPage airPlaneFlightRouteMapperPage;
    private final AirPlaneMapperPage airPlaneMapperPage;
    private final AirCompanyMapperPage airCompanyMapperPage;

    public FlightRouteDTOModif toDTO(ViewingFlightInformationPage viewingFlightInformationPage) {
        return modelMapper.map(viewingFlightInformationPage, FlightRouteDTOModif.class);
    }

    public List<FlightRouteDTOModif> toDTO(List<ViewingFlightInformationPage> viewingFlightInformationPageList) {
        return Optional.ofNullable(viewingFlightInformationPageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<ViewingFlightInformationPage> toPage(List<FlightRouteDTOModif> flightRouteDTOModifList) {
        return Optional.ofNullable(flightRouteDTOModifList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public ViewingFlightInformationPage toPage(FlightRouteDTOModif flightRouteDTOModif) {
        List<AirPlaneFlightRouteDTOModif> airPlaneFlightRouteDTOModifList =
                flightRouteDTOModif.getAirPlaneFlightRouteList();
        List<AirPlaneDTOModif> airPlaneDTOModifList =
                airPlaneFlightRouteDTOModifList.stream()
                        .map(AirPlaneFlightRouteDTOModif::getAirPlane)
                        .collect(Collectors.toList());
        List<AirCompanyDTO> airCompanyDTOList =
                airPlaneDTOModifList.stream()
                        .map(AirPlaneDTOModif::getAirCompany)
                        .collect(Collectors.toList());
        return ViewingFlightInformationPage.builder()
                .id(flightRouteDTOModif.getId())
                .routeStart(flightRouteDTOModif.getRouteStart())
                .routeEnd(flightRouteDTOModif.getRouteEnd())
                .distance(flightRouteDTOModif.getDistance())
                .flightDateStart(flightRouteDTOModif.getFlightDateStart())
                .flightDateEnd(flightRouteDTOModif.getFlightDateEnd())
                .duration(flightRouteDTOModif.getDuration())
                .price(flightRouteDTOModif.getPrice())
                .airPlaneFlightRouteList(airPlaneFlightRouteMapperPage.toPage(airPlaneFlightRouteDTOModifList))
                .airPlaneList(airPlaneMapperPage.toPage(airPlaneDTOModifList))
                .airCompanyList(airCompanyMapperPage.toPage(airCompanyDTOList))
                .isActive(flightRouteDTOModif.getIsActive())
                .build();
    }


}
