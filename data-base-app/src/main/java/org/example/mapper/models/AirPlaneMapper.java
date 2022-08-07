package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirPlaneDTO;
import org.example.model.AirPlane;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class AirPlaneMapper {
    private final ModelMapper modelMapper;

    public AirPlaneDTO toDTO(AirPlane airPlane) {
        return modelMapper.map(airPlane, AirPlaneDTO.class);
    }

    public List<AirPlaneDTO> toDTO(List<AirPlane> airPlaneList) {
        return Optional.ofNullable(airPlaneList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlane> toModel(List<AirPlaneDTO> airPlaneDTOList) {
        return Optional.ofNullable(airPlaneDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public AirPlane toModel(AirPlaneDTO airPlaneDTO) {
        return modelMapper.map(airPlaneDTO, AirPlane.class);
    }
}
