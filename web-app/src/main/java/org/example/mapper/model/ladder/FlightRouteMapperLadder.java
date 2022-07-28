package org.example.mapper.model.ladder;

import lombok.RequiredArgsConstructor;
import org.example.dto.ladder.FlightRouteDTOLdder;
import org.example.model.database.FlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperLadder {

    public FlightRouteDTOLdder toDTO(FlightRoute flightRoute) {
        return FlightRouteDTOLdder.builder()
                .id(flightRoute.getId())
                .routeStart(flightRoute.getRouteStart())
                .routeEnd(flightRoute.getRouteEnd())
                .distance(flightRoute.getDistance())
                .flightDateStart(flightRoute.getFlightDateStart())
                .flightDateEnd(flightRoute.getFlightDateEnd())
                .isActive(flightRoute.getIsActive())
                .build();
    }

    public List<FlightRouteDTOLdder> toDTO(List<FlightRoute> flightRouteList) {
        return flightRouteList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FlightRoute> toModel(List<FlightRouteDTOLdder> flightRouteDTOLdderList) {
        return flightRouteDTOLdderList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FlightRoute toModel(FlightRouteDTOLdder flightRouteDTOLdder) {
        return FlightRoute.builder()
                .id(flightRouteDTOLdder.getId())
                .routeStart(flightRouteDTOLdder.getRouteStart())
                .routeEnd(flightRouteDTOLdder.getRouteEnd())
                .distance(flightRouteDTOLdder.getDistance())
                .flightDateStart(flightRouteDTOLdder.getFlightDateStart())
                .flightDateEnd(flightRouteDTOLdder.getFlightDateEnd())
                .isActive(flightRouteDTOLdder.getIsActive())
                .build();
    }
}
