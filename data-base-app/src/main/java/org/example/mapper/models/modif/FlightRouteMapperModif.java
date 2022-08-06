package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.model.FlightRoute;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperModif {
    private final ModelMapper modelMapper;

    public FlightRouteDTOModif toDTO(FlightRoute flightRoute) {
        return modelMapper.map(flightRoute, FlightRouteDTOModif.class);
    }

    public List<FlightRouteDTOModif> toDTO(List<FlightRoute> flightRouteList) {
        return Optional.ofNullable(flightRouteList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<FlightRoute> toModel(List<FlightRouteDTOModif> flightRouteDTOModifList) {
        return Optional.ofNullable(flightRouteDTOModifList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public FlightRoute toModel(FlightRouteDTOModif flightRouteDTOModif) {
        return modelMapper.map(flightRouteDTOModif, FlightRoute.class);
    }
}
