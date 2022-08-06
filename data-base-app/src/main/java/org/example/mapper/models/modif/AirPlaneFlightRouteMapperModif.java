package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneFlightRouteDTOModif;
import org.example.model.AirPlaneFlightRoute;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneFlightRouteMapperModif {
    private final AirPlaneMapperModif airPlaneMapperModif;

    private final ModelMapper modelMapper;

    public AirPlaneFlightRouteDTOModif toDTO(AirPlaneFlightRoute airPlaneFlightRoute) {
        return modelMapper.map(airPlaneFlightRoute, AirPlaneFlightRouteDTOModif.class);
    }

    public List<AirPlaneFlightRouteDTOModif> toDTO(List<AirPlaneFlightRoute> airPlaneFlightRouteList) {
        return Optional.ofNullable(airPlaneFlightRouteList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlaneFlightRoute> toModel(List<AirPlaneFlightRouteDTOModif> airPlaneFlightRouteDTOModifList) {
        return Optional.ofNullable(airPlaneFlightRouteDTOModifList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public AirPlaneFlightRoute toModel(AirPlaneFlightRouteDTOModif airPlaneFlightRouteDTOModif) {
        return modelMapper.map(airPlaneFlightRouteDTOModif, AirPlaneFlightRoute.class);
    }
}
