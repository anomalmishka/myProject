package org.example.mapper.modelsMapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.mapper.modelsMapper.TicketMapper;
import org.example.model.entity.AirPlane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class AirPlaneMapperModif {
    private final TicketMapper ticketMapper;

    public AirPlaneDTOModif toDTO(AirPlane airPlane) {
        return AirPlaneDTOModif.builder()
                .id(airPlane.getId())
                .type(airPlane.getType())
                .routeStart(airPlane.getRouteStart())
                .routeEnd(airPlane.getRouteEnd())
                .ticketPrice(airPlane.getTicketPrice())
                .numberPassanger(airPlane.getNumberPassanger())
                .flightDateStart(airPlane.getFlightDateStart())
                .flightDateEnd(airPlane.getFlightDateEnd())
                .ticketDTOS(ticketMapper.toDTO(airPlane.getTickets()))
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
                .routeStart(airPlaneDTOModif.getRouteStart())
                .routeEnd(airPlaneDTOModif.getRouteEnd())
                .ticketPrice(airPlaneDTOModif.getTicketPrice())
                .numberPassanger(airPlaneDTOModif.getNumberPassanger())
                .flightDateStart(airPlaneDTOModif.getFlightDateStart())
                .flightDateEnd(airPlaneDTOModif.getFlightDateEnd())
                .tickets(ticketMapper.toModel(airPlaneDTOModif.getTicketDTOS()))
                .build();
    }
}
