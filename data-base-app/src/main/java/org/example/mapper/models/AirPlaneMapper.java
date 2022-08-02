package org.example.mapper.models;

import org.example.dto.modelsDTO.AirPlaneDTO;
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
                .status(airPlane.getStatus())
                .numberSeatLowcost(airPlane.getNumberSeatLowcost())
                .numberSeatBuisness(airPlane.getNumberSeatBuisness())
                .isActive(airPlane.getIsActive())
                .build();
    }

    public List<AirPlaneDTO> toDTO(List<AirPlane> airPlaneList) {
        return airPlaneList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlane> toModel(List<AirPlaneDTO> airPlaneDTOList) {
        return airPlaneDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlane toModel(AirPlaneDTO airPlaneDTO) {
        return AirPlane.builder()
                .id(airPlaneDTO.getId())
                .type(airPlaneDTO.getType())
                .status(airPlaneDTO.getStatus())
                .numberSeatLowcost(airPlaneDTO.getNumberSeatLowcost())
                .numberSeatBuisness(airPlaneDTO.getNumberSeatBuisness())
                .isActive(airPlaneDTO.getIsActive())
                .build();
    }
}
