package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.page.FlightRoutePage;
import org.example.model.database.AirPlane;
import org.example.model.database.FlightRoute;
import org.example.model.database.UserOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperPage {
    public FlightRoutePage toPageDTO(FlightRoute flightRoute) {
        List<AirPlane> airPlaneList = flightRoute.getAirPlaneList();
        List<UserOrder> userOrderList = flightRoute.getUserOrderList();
        return FlightRoutePage.builder()
                .idFlightRoute(flightRoute.getId())
                .routeStartFlightRoute(flightRoute.getRouteStart())
                .routeEndFlightRoute(flightRoute.getRouteEnd())
                .distanceFlightRoute(flightRoute.getDistance())
                .flightDateStartFlightRoute(flightRoute.getFlightDateStart())
                .flightDateEndFlightRoute(flightRoute.getFlightDateEnd())
                .isActiveFlightRoute(flightRoute.getIsActive())

                .idAirPlane(airPlaneList.stream().map(AirPlane::getId).collect(Collectors.toList()))
                .typeAirPlane(airPlaneList.stream().map(AirPlane::getType).collect(Collectors.toList()))
                .statusAirPlane(airPlaneList.stream().map(AirPlane::getStatus).collect(Collectors.toList()))
                .numberSeatLowcostAirPlane(airPlaneList.stream().map(AirPlane::getNumberSeatLowcost).collect(Collectors.toList()))
                .numberSeatBuisnessAirPlane(airPlaneList.stream().map(AirPlane::getNumberSeatBuisness).collect(Collectors.toList()))
                .pricePerKilometerAirPlane(airPlaneList.stream().map(AirPlane::getPricePerKilometer).collect(Collectors.toList()))
                .isActiveAirPlane(airPlaneList.stream().map(AirPlane::getIsActive).collect(Collectors.toList()))

                .idUserOrder(userOrderList.stream().map(UserOrder::getId).collect(Collectors.toList()))
                .build();
    }

    public List<FlightRoutePage> toPageDTO(List<FlightRoute> flightRouteList) {
        return flightRouteList.stream().map(this::toPageDTO).collect(Collectors.toList());
    }
}
