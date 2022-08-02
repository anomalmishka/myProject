package org.example.mapper.models.modif2;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.example.model.entity.FlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperModif2 {
    private final AirPlaneFlightRouteMapperModif2 airPlaneFlightRouteMapperModif2;

    public FlightRouteDTOModif2 toDTO(FlightRoute flightRoute) {
        return FlightRouteDTOModif2.builder()
                .id(flightRoute.getId())
                .routeStart(flightRoute.getRouteStart())
                .routeEnd(flightRoute.getRouteEnd())
                .distance(flightRoute.getDistance())
                .flightDateStart(flightRoute.getFlightDateStart())
                .flightDateEnd(flightRoute.getFlightDateEnd())
                .price(flightRoute.getPrice())
                .isActive(flightRoute.getIsActive())
                .airPlaneFlightRouteDTOModif2List(airPlaneFlightRouteMapperModif2.toDTO(flightRoute.getAirPlaneFlightRouteList()))
                .build();
    }

    public List<FlightRouteDTOModif2> toDTO(List<FlightRoute> flightRouteList) {
        return flightRouteList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FlightRoute> toModel(List<FlightRouteDTOModif2> flightRouteDTOModif2List) {
        return flightRouteDTOModif2List.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FlightRoute toModel(FlightRouteDTOModif2 flightRouteDTOModif2) {
        return FlightRoute.builder()
                .id(flightRouteDTOModif2.getId())
                .routeStart(flightRouteDTOModif2.getRouteStart())
                .routeEnd(flightRouteDTOModif2.getRouteEnd())
                .distance(flightRouteDTOModif2.getDistance())
                .flightDateStart(flightRouteDTOModif2.getFlightDateStart())
                .flightDateEnd(flightRouteDTOModif2.getFlightDateEnd())
                .price(flightRouteDTOModif2.getPrice())
                .isActive(flightRouteDTOModif2.getIsActive())
                .airPlaneFlightRouteList(airPlaneFlightRouteMapperModif2.toModel(flightRouteDTOModif2.getAirPlaneFlightRouteDTOModif2List()))
                .build();
    }
}
