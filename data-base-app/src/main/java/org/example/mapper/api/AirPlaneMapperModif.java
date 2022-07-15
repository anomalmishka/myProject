package org.example.mapper.api;

import org.example.dto.api.AirPlaneDTOModif;
import org.example.model.AirPlane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirPlaneMapperModif {
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
                .tickets(airPlane.getTickets())
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
                .tickets(airPlaneDTOModif.getTickets())
                .build();
    }
}
