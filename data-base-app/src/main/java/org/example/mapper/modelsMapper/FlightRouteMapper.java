package org.example.mapper.modelsMapper;

import org.example.dto.models.FlightRouteDTO;
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
                .flightDateStart(flightRoute.getFlightDateStart())
                .flightDateEnd(flightRoute.getFlightDateEnd())
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
                .flightDateStart(flightRouteDTO.getFlightDateStart())
                .flightDateEnd(flightRouteDTO.getFlightDateEnd())
                .build();
    }
}
