package org.example.mapper.modelsMapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.*;
import org.example.model.entity.FlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperModif {
    private final OrderMapperModif orderMapperModif;
    private final SeatMapperModif seatMapperModif;

    public FlightRouteDTOModif toDTO(FlightRoute flightRoute) {
        return FlightRouteDTOModif.builder()
                .id(flightRoute.getId())
                .routeStart(flightRoute.getRouteStart())
                .routeEnd(flightRoute.getRouteEnd())
                .flightDateStart(flightRoute.getFlightDateStart())
                .flightDateEnd(flightRoute.getFlightDateEnd())
                .orderDTOModifList(orderMapperModif.toDTO(flightRoute.getUserOrderList()))
                .seatDTOModifList(seatMapperModif.toDTO(flightRoute.getSeatList()))
                .build();
    }

    public List<FlightRouteDTOModif> toDTO(List<FlightRoute> flightRouteList) {
        return flightRouteList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FlightRoute> toModel(List<FlightRouteDTOModif> flightRouteDTOModifList) {
        return flightRouteDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FlightRoute toModel(FlightRouteDTOModif flightRouteDTOModif) {
        return FlightRoute.builder()
                .id(flightRouteDTOModif.getId())
                .routeStart(flightRouteDTOModif.getRouteStart())
                .routeEnd(flightRouteDTOModif.getRouteEnd())
                .flightDateStart(flightRouteDTOModif.getFlightDateStart())
                .flightDateEnd(flightRouteDTOModif.getFlightDateEnd())
                .userOrderList(orderMapperModif.toModel(flightRouteDTOModif.getOrderDTOModifList()))
                .seatList(seatMapperModif.toModel(flightRouteDTOModif.getSeatDTOModifList()))
                .build();
    }
}
