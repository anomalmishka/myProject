package org.example.mapper.models.modif2;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.AirPlaneFlightRouteDTOModif2;
import org.example.mapper.models.modif.AirPlaneMapperModif;
import org.example.model.entity.AirPlaneFlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneFlightRouteMapperModif2 {
    private final AirPlaneMapperModif airPlaneMapperModif;

    public AirPlaneFlightRouteDTOModif2 toDTO(AirPlaneFlightRoute airPlaneFlightRoute) {
        return AirPlaneFlightRouteDTOModif2.builder()
                .id(airPlaneFlightRoute.getId())
                .airPlaneDTOModif(airPlaneMapperModif.toDTO(airPlaneFlightRoute.getAirPlane()))
                .build();
    }

    public List<AirPlaneFlightRouteDTOModif2> toDTO(List<AirPlaneFlightRoute> airPlaneFlightRouteList) {
        return airPlaneFlightRouteList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlaneFlightRoute> toModel(List<AirPlaneFlightRouteDTOModif2> airPlaneFlightRouteDTOModif2List) {
        return airPlaneFlightRouteDTOModif2List.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlaneFlightRoute toModel(AirPlaneFlightRouteDTOModif2 airPlaneFlightRouteDTOModif2) {
        return AirPlaneFlightRoute.builder()
                .id(airPlaneFlightRouteDTOModif2.getId())
                .airPlane(airPlaneMapperModif.toModel(airPlaneFlightRouteDTOModif2.getAirPlaneDTOModif()))
                .build();
    }
}
