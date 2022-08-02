package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.AirPlaneFlightRouteDTOModif;
import org.example.mapper.models.AirPlaneMapper;
import org.example.model.entity.AirPlaneFlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneFlightRouteMapperModif {
    private final AirPlaneMapper airPlaneMapper;

    public AirPlaneFlightRouteDTOModif toDTO(AirPlaneFlightRoute airPlaneFlightRoute) {
        return AirPlaneFlightRouteDTOModif.builder()
                .id(airPlaneFlightRoute.getId())
                .airPlaneDTO(airPlaneMapper.toDTO(airPlaneFlightRoute.getAirPlane()))
                .build();
    }

    public List<AirPlaneFlightRouteDTOModif> toDTO(List<AirPlaneFlightRoute> airPlaneFlightRouteList) {
        return airPlaneFlightRouteList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlaneFlightRoute> toModel(List<AirPlaneFlightRouteDTOModif> airPlaneFlightRouteDTOModifList) {
        return airPlaneFlightRouteDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlaneFlightRoute toModel(AirPlaneFlightRouteDTOModif airPlaneFlightRouteDTOModif) {
        return AirPlaneFlightRoute.builder()
                .id(airPlaneFlightRouteDTOModif.getId())
                .airPlane(airPlaneMapper.toModel(airPlaneFlightRouteDTOModif.getAirPlaneDTO()))
                .build();
    }
}
