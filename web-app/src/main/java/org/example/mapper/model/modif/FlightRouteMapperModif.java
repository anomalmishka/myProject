package org.example.mapper.model.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.mapper.model.AirPlaneMapper;
import org.example.mapper.model.UserOrderMapper;
import org.example.model.database.FlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperModif {
    private final AirPlaneMapper airPlaneMapper;
    private final UserOrderMapper userOrderMapper;

    public FlightRouteDTOModif toDTO(FlightRoute flightRoute) {
        return FlightRouteDTOModif.builder()
                .id(flightRoute.getId())
                .routeStart(flightRoute.getRouteStart())
                .routeEnd(flightRoute.getRouteEnd())
                .distance(flightRoute.getDistance())
                .flightDateStart(flightRoute.getFlightDateStart())
                .flightDateEnd(flightRoute.getFlightDateEnd())
                .isActive(flightRoute.getIsActive())
//                .airPlaneDTOList(airPlaneMapper.toDTO(flightRoute.getAirPlaneList()))
                .userOrderDTOList(userOrderMapper.toDTO(flightRoute.getUserOrderList()))
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
                .distance(flightRouteDTOModif.getDistance())
                .flightDateStart(flightRouteDTOModif.getFlightDateStart())
                .flightDateEnd(flightRouteDTOModif.getFlightDateEnd())
                .isActive(flightRouteDTOModif.getIsActive())
//                .airPlaneList(airPlaneMapper.toModel(flightRouteDTOModif.getAirPlaneDTOList()))
                .userOrderList(userOrderMapper.toModel(flightRouteDTOModif.getUserOrderDTOList()))
                .build();
    }
}
