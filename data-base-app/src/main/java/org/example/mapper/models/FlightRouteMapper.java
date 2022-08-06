package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.FlightRouteDTO;
import org.example.model.FlightRoute;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class FlightRouteMapper {

    private final ModelMapper modelMapper;

    public FlightRouteDTO toDTO(FlightRoute flightRoute) {
        return modelMapper.map(flightRoute, FlightRouteDTO.class);

    }

    public List<FlightRouteDTO> toDTO(List<FlightRoute> flightRouteList) {
        return Optional.ofNullable(flightRouteList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<FlightRoute> toModel(List<FlightRouteDTO> flightRouteDTOList) {
        return Optional.ofNullable(flightRouteDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public FlightRoute toModel(FlightRouteDTO flightRouteDTO) {
        return modelMapper.map(flightRouteDTO, FlightRoute.class);
    }
}
