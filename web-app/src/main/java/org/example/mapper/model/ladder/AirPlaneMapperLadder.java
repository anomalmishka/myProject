package org.example.mapper.model.ladder;

import lombok.RequiredArgsConstructor;
import org.example.dto.ladder.AirPlaneDTOLadder;
import org.example.model.database.AirPlane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperLadder {
    private final FlightRouteMapperLadder flightRouteMapperLadder;
    private final SeatMapperLadder seatMapperLadder;

    public AirPlaneDTOLadder toDTO(AirPlane airPlane) {
        return AirPlaneDTOLadder.builder()
                .id(airPlane.getId())
                .type(airPlane.getType())
                .status(airPlane.getStatus())
                .numberSeatLowcost(airPlane.getNumberSeatLowcost())
                .numberSeatBuisness(airPlane.getNumberSeatBuisness())
                .pricePerKilometer(airPlane.getPricePerKilometer())
                .isActive(airPlane.getIsActive())
                .flightRouteDTOLdderList(flightRouteMapperLadder.toDTO(airPlane.getFlightRouteList()))
                .seatDTOLadderList(seatMapperLadder.toDTO(airPlane.getSeatList()))
                .build();
    }

    public List<AirPlaneDTOLadder> toDTO(List<AirPlane> airPlaneList) {
        return airPlaneList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlane> toModel(List<AirPlaneDTOLadder> airPlaneDTOLadderList) {
        return airPlaneDTOLadderList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlane toModel(AirPlaneDTOLadder airPlaneDTOLadder) {
        return AirPlane.builder()
                .id(airPlaneDTOLadder.getId())
                .type(airPlaneDTOLadder.getType())
                .status(airPlaneDTOLadder.getStatus())
                .numberSeatLowcost(airPlaneDTOLadder.getNumberSeatLowcost())
                .numberSeatBuisness(airPlaneDTOLadder.getNumberSeatBuisness())
                .pricePerKilometer(airPlaneDTOLadder.getPricePerKilometer())
                .isActive(airPlaneDTOLadder.getIsActive())
                .flightRouteList(flightRouteMapperLadder.toModel(airPlaneDTOLadder.getFlightRouteDTOLdderList()))
                .seatList(seatMapperLadder.toModel(airPlaneDTOLadder.getSeatDTOLadderList()))
                .build();
    }
}
