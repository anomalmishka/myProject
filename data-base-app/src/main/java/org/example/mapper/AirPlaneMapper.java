package org.example.mapper;


import org.example.dto.AirPlaneDTO;
import org.example.model.AirPlane;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirPlaneMapper {
    public AirPlaneDTO toDTO(AirPlane airPlane) {
        return AirPlaneDTO.builder()
                .id(airPlane.getId())
                .type(airPlane.getType())
                .routeStart(airPlane.getRouteStart())
                .routeEnd(airPlane.getRouteEnd())
                .numberPassanger(airPlane.getNumberPassanger())
                .flightDate(airPlane.getFlightDate())
                .build();
    }

    public List<AirPlaneDTO> toDTO(List<AirPlane> airPlanes) {
        return airPlanes.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<AirPlane> toModel(List<AirPlaneDTO> airPlaneDTOS) {
        return airPlaneDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlane toModel(AirPlaneDTO airPlaneDTO) {
        return AirPlane.builder()
                .id(airPlaneDTO.getId())
                .type(airPlaneDTO.getType())
                .routeStart(airPlaneDTO.getRouteStart())
                .routeEnd(airPlaneDTO.getRouteEnd())
                .numberPassanger(airPlaneDTO.getNumberPassanger())
                .flightDate(airPlaneDTO.getFlightDate())
                .build();
    }
}
