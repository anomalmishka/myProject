package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirPlaneDTO;
import org.example.dto.models.UserOrderDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.dto.page.FlightRoutePage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperPage {

    public FlightRoutePage toPageDTO(FlightRouteDTOModif flightRouteDTOModif) {
        List<AirPlaneDTO> airPlaneDTOList = flightRouteDTOModif.getAirPlaneDTOList();
        List<UserOrderDTO> userOrderDTOList = flightRouteDTOModif.getUserOrderDTOList();
        return FlightRoutePage.builder()
                .idFlightRoute(flightRouteDTOModif.getId())
                .routeStartFlightRoute(flightRouteDTOModif.getRouteStart())
                .routeEndFlightRoute(flightRouteDTOModif.getRouteEnd())
                .distanceFlightRoute(flightRouteDTOModif.getDistance())
                .flightDateStartFlightRoute(flightRouteDTOModif.getFlightDateStart())
                .flightDateEndFlightRoute(flightRouteDTOModif.getFlightDateEnd())
                .isActiveFlightRoute(flightRouteDTOModif.getIsActive())

                .idAirPlane(airPlaneDTOList.stream().map(AirPlaneDTO::getId).collect(Collectors.toList()))
                .typeAirPlane(airPlaneDTOList.stream().map(AirPlaneDTO::getType).collect(Collectors.toList()))
                .statusAirPlane(airPlaneDTOList.stream().map(AirPlaneDTO::getStatus).collect(Collectors.toList()))
                .numberSeatLowcostAirPlane(airPlaneDTOList.stream().map(AirPlaneDTO::getNumberSeatLowcost).collect(Collectors.toList()))
                .numberSeatBuisnessAirPlane(airPlaneDTOList.stream().map(AirPlaneDTO::getNumberSeatBuisness).collect(Collectors.toList()))
                .pricePerKilometerAirPlane(airPlaneDTOList.stream().map(AirPlaneDTO::getPricePerKilometer).collect(Collectors.toList()))
                .isActiveAirPlane(airPlaneDTOList.stream().map(AirPlaneDTO::getIsActive).collect(Collectors.toList()))

                .idUserOrder(userOrderDTOList.stream().map(UserOrderDTO::getId).collect(Collectors.toList()))
                .build();
    }

    public List<FlightRoutePage> toPageDTO(List<FlightRouteDTOModif> flightRouteDTOModifList) {
        return flightRouteDTOModifList.stream().map(this::toPageDTO).collect(Collectors.toList());
    }
}
