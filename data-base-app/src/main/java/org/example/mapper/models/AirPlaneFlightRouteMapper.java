package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirPlaneFlightRouteDTO;
import org.example.model.AirPlaneFlightRoute;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneFlightRouteMapper {
    private final ModelMapper modelMapper;
    public AirPlaneFlightRouteDTO toDTO(AirPlaneFlightRoute airPlaneFlightRoute) {
        return modelMapper.map(airPlaneFlightRoute, AirPlaneFlightRouteDTO.class);
    }

    public List<AirPlaneFlightRouteDTO> toDTO(List<AirPlaneFlightRoute> airPlaneFlightRouteList) {
        return Optional.ofNullable(airPlaneFlightRouteList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlaneFlightRoute> toModel(List<AirPlaneFlightRouteDTO> airPlaneFlightRouteDTOList) {
        return Optional.ofNullable(airPlaneFlightRouteDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public AirPlaneFlightRoute toModel(AirPlaneFlightRouteDTO airPlaneFlightRouteDTO) {
        return modelMapper.map(airPlaneFlightRouteDTO, AirPlaneFlightRoute.class);
    }
}
