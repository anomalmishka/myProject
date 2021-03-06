package org.example.mapper.models;

import org.example.dto.modelsDTO.FlightRouteDTO;
import org.example.model.entity.FlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightRouteMapper {
    public FlightRouteDTO toDTO(FlightRoute flightRoute) {
        return FlightRouteDTO.builder()
                .id(flightRoute.getId())
                .routeStart(flightRoute.getRouteStart())
                .routeEnd(flightRoute.getRouteEnd())
                .distance(flightRoute.getDistance())
                .flightDateStart(flightRoute.getFlightDateStart())
                .flightDateEnd(flightRoute.getFlightDateEnd())
                .price(flightRoute.getPrice())
                .isActive(flightRoute.getIsActive())
                .build();
    }

    public List<FlightRouteDTO> toDTO(List<FlightRoute> flightRouteList) {
        return flightRouteList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FlightRoute> toModel(List<FlightRouteDTO> flightRouteDTOList) {
        return flightRouteDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FlightRoute toModel(FlightRouteDTO flightRouteDTO) {
        return FlightRoute.builder()
                .id(flightRouteDTO.getId())
                .routeStart(flightRouteDTO.getRouteStart())
                .routeEnd(flightRouteDTO.getRouteEnd())
                .distance(flightRouteDTO.getDistance())
                .flightDateStart(flightRouteDTO.getFlightDateStart())
                .flightDateEnd(flightRouteDTO.getFlightDateEnd())
                .price(flightRouteDTO.getPrice())
                .isActive(flightRouteDTO.getIsActive())
                .build();
    }
}
