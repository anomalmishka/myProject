package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.mapper.models.AirCompanyMapper;
import org.example.mapper.models.FlightRouteMapper;
import org.example.mapper.models.SeatMapper;
import org.example.model.entity.AirPlane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperModif {
    private final AirCompanyMapper airCompanyMapper;
    private final FlightRouteMapper flightRouteMapper;
    private final SeatMapper seatMapper;

    public AirPlaneDTOModif toDTO(AirPlane airPlane) {
        return AirPlaneDTOModif.builder()
                .id(airPlane.getId())
                .type(airPlane.getType())
                .status(airPlane.getStatus())
                .numberSeatLowcost(airPlane.getNumberSeatLowcost())
                .numberSeatBuisness(airPlane.getNumberSeatBuisness())
                .pricePerKilometer(airPlane.getPricePerKilometer())
                .isActive(airPlane.getIsActive())
                .airCompanyDTO(airCompanyMapper.toDTO(airPlane.getAirCompany()))
                .flightRouteDTOList(flightRouteMapper.toDTO(airPlane.getFlightRouteList()))
                .seatDTOList(seatMapper.toDTO(airPlane.getSeatList()))
                .build();
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlane> airPlaneList) {
        return airPlaneList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlane> toModel(List<AirPlaneDTOModif> airPlaneDTOModifList) {
        return airPlaneDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlane toModel(AirPlaneDTOModif airPlaneDTOModif) {
        return AirPlane.builder()
                .id(airPlaneDTOModif.getId())
                .type(airPlaneDTOModif.getType())
                .status(airPlaneDTOModif.getStatus())
                .numberSeatLowcost(airPlaneDTOModif.getNumberSeatLowcost())
                .numberSeatBuisness(airPlaneDTOModif.getNumberSeatBuisness())
                .pricePerKilometer(airPlaneDTOModif.getPricePerKilometer())
                .isActive(airPlaneDTOModif.getIsActive())
                .airCompany(airCompanyMapper.toModel(airPlaneDTOModif.getAirCompanyDTO()))
                .flightRouteList(flightRouteMapper.toModel(airPlaneDTOModif.getFlightRouteDTOList()))
                .seatList(seatMapper.toModel(airPlaneDTOModif.getSeatDTOList()))
                .build();
    }
}
