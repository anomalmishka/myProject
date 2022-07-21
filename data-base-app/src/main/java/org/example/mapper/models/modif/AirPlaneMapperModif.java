package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.mapper.models.FlightRouteMapper;
import org.example.mapper.models.SeatMapper;
import org.example.model.entity.AirPlane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperModif {
    private final FlightRouteMapper flightRouteMapper;
    private final SeatMapper seatMapper;

    public AirPlaneDTOModif toDTO(AirPlane airPlane) {
        return AirPlaneDTOModif.builder()
                .id(airPlane.getId())
                .type(airPlane.getType())
                .status(airPlane.getStatus())
                .numberSeatLowcost(airPlane.getNumberSeatLowcost())
                .numberSeatBuisness(airPlane.getNumberSeatBuisness())
                .priceLowcost(airPlane.getPriceLowcost())
                .priceBuisness(airPlane.getPriceBuisness())                .isActive(airPlane.getIsActive())
                .flightRouteDTOList(flightRouteMapper.toDTO(airPlane.getFlightRouteList()))
                .seatDTOList(seatMapper.toDTO(airPlane.getSeatList()))
                .build();
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlane> airPlanes) {
        return airPlanes.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlane> toModel(List<AirPlaneDTOModif> airPlaneDTOModifs) {
        return airPlaneDTOModifs.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlane toModel(AirPlaneDTOModif airPlaneDTOModif) {
        return AirPlane.builder()
                .id(airPlaneDTOModif.getId())
                .type(airPlaneDTOModif.getType())
                .status(airPlaneDTOModif.getStatus())
                .numberSeatLowcost(airPlaneDTOModif.getNumberSeatLowcost())
                .numberSeatBuisness(airPlaneDTOModif.getNumberSeatBuisness())
                .priceLowcost(airPlaneDTOModif.getPriceLowcost())
                .priceBuisness(airPlaneDTOModif.getPriceBuisness())                .isActive(airPlaneDTOModif.getIsActive())
                .flightRouteList(flightRouteMapper.toModel(airPlaneDTOModif.getFlightRouteDTOList()))
                .seatList(seatMapper.toModel(airPlaneDTOModif.getSeatDTOList()))
                .build();
    }
}
