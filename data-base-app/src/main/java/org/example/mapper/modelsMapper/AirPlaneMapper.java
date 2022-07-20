package org.example.mapper.modelsMapper;

import org.example.dto.models.AirPlaneDTO;
import org.example.model.entity.AirPlane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirPlaneMapper {

    public AirPlaneDTO toDTO(AirPlane airPlane) {
        return AirPlaneDTO.builder()
                .id(airPlane.getId())
                .type(airPlane.getType())
                .numberSeat(airPlane.getNumberSeat())
                .build();
    }

    public List<AirPlaneDTO> toDTO(List<AirPlane> airPlanes) {
        return airPlanes.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<AirPlane> toModel(List<AirPlaneDTO> airPlaneDTOS) {
        return airPlaneDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlane toModel(AirPlaneDTO airPlaneDTO) {
        return AirPlane.builder()
                .id(airPlaneDTO.getId())
                .type(airPlaneDTO.getType())
                .numberSeat(airPlaneDTO.getNumberSeat())
                .build();
    }
}
