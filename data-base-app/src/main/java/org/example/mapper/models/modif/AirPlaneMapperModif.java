package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.model.AirPlane;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperModif {
    private final ModelMapper modelMapper;

    public AirPlaneDTOModif toDTO(AirPlane airPlane) {
        return modelMapper.map(airPlane, AirPlaneDTOModif.class);
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlane> airPlaneList) {
        return Optional.ofNullable(airPlaneList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlane> toModel(List<AirPlaneDTOModif> airPlaneDTOModifList) {
        return Optional.ofNullable(airPlaneDTOModifList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public AirPlane toModel(AirPlaneDTOModif airPlaneDTOModif) {
        return modelMapper.map(airPlaneDTOModif, AirPlane.class);
    }
}
