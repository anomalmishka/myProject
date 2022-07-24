package org.example.mapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.mapper.model.AirCompanyMapper;
import org.example.mapper.model.FlightRouteMapper;
import org.example.mapper.model.SeatMapper;
import org.example.model.obj.database.modif.AirPlaneModif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperModif {
    private final AirCompanyMapper airCompanyMapper;
    private final FlightRouteMapper flightRouteMapper;
    private final SeatMapper seatMapper;

    public AirPlaneDTOModif toDTO(AirPlaneModif airPlaneModif) {
        return AirPlaneDTOModif.builder()
                .id(airPlaneModif.getId())
                .type(airPlaneModif.getType())
                .status(airPlaneModif.getStatus())
                .numberSeatLowcost(airPlaneModif.getNumberSeatLowcost())
                .numberSeatBuisness(airPlaneModif.getNumberSeatBuisness())
                .pricePerKilometer(airPlaneModif.getPricePerKilometer())
                .isActive(airPlaneModif.getIsActive())
                .airCompanyDTO(airCompanyMapper.toDTO(airPlaneModif.getAirCompany()))
                .flightRouteDTOList(flightRouteMapper.toDTO(airPlaneModif.getFlightRouteList()))
                .seatDTOList(seatMapper.toDTO(airPlaneModif.getSeatList()))
                .build();
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlaneModif> airPlaneModifList) {
        return airPlaneModifList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlaneModif> toModel(List<AirPlaneDTOModif> airPlaneDTOModifs) {
        return airPlaneDTOModifs.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlaneModif toModel(AirPlaneDTOModif airPlaneDTOModif) {
        return AirPlaneModif.builder()
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
