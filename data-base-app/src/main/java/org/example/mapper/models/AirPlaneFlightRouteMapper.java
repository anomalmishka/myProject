package org.example.mapper.models;

import org.example.dto.modelsDTO.AirPlaneFlightRouteDTO;
import org.example.model.entity.AirPlaneFlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirPlaneFlightRouteMapper {

    public AirPlaneFlightRouteDTO toDTO(AirPlaneFlightRoute airPlaneFlightRoute) {
        return AirPlaneFlightRouteDTO.builder()
                .id(airPlaneFlightRoute.getId())
                .build();
    }

    public List<AirPlaneFlightRouteDTO> toDTO(List<AirPlaneFlightRoute> airPlaneFlightRouteList) {
        return airPlaneFlightRouteList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlaneFlightRoute> toModel(List<AirPlaneFlightRouteDTO> airPlaneFlightRouteDTOList) {
        return airPlaneFlightRouteDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlaneFlightRoute toModel(AirPlaneFlightRouteDTO airPlaneFlightRouteDTO) {
        return AirPlaneFlightRoute.builder()
                .id(airPlaneFlightRouteDTO.getId())
                .build();
    }
}
