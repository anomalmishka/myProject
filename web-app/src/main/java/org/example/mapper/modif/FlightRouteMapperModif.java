package org.example.mapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.mapper.model.AirPlaneMapper;
import org.example.mapper.model.UserOrderMapper;
import org.example.model.obj.database.modif.FlightRouteModif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperModif {
    private final AirPlaneMapper airPlaneMapper;
    private final UserOrderMapper userOrderMapper;

    public FlightRouteDTOModif toDTO(FlightRouteModif flightRouteModif) {
        return FlightRouteDTOModif.builder()
                .id(flightRouteModif.getId())
                .routeStart(flightRouteModif.getRouteStart())
                .routeEnd(flightRouteModif.getRouteEnd())
                .distance(flightRouteModif.getDistance())
                .flightDateStart(flightRouteModif.getFlightDateStart())
                .flightDateEnd(flightRouteModif.getFlightDateEnd())
                .isActive(flightRouteModif.getIsActive())
                .airPlaneDTOList(airPlaneMapper.toDTO(flightRouteModif.getAirPlaneList()))
                .userOrderDTOList(userOrderMapper.toDTO(flightRouteModif.getUserOrderList()))
                .build();
    }

    public List<FlightRouteDTOModif> toDTO(List<FlightRouteModif> flightRouteModifList) {
        return flightRouteModifList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FlightRouteModif> toModel(List<FlightRouteDTOModif> flightRouteDTOModifList) {
        return flightRouteDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FlightRouteModif toModel(FlightRouteDTOModif flightRouteDTOModif) {
        return FlightRouteModif.builder()
                .id(flightRouteDTOModif.getId())
                .routeStart(flightRouteDTOModif.getRouteStart())
                .routeEnd(flightRouteDTOModif.getRouteEnd())
                .distance(flightRouteDTOModif.getDistance())
                .flightDateStart(flightRouteDTOModif.getFlightDateStart())
                .flightDateEnd(flightRouteDTOModif.getFlightDateEnd())
                .isActive(flightRouteDTOModif.getIsActive())
                .airPlaneList(airPlaneMapper.toModel(flightRouteDTOModif.getAirPlaneDTOList()))
                .userOrderList(userOrderMapper.toModel(flightRouteDTOModif.getUserOrderDTOList()))
                .build();
    }
}
