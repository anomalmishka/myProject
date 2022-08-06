
package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.dto.page.AirPlanePage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperPage {
    private final ModelMapper modelMapper;

    public AirPlaneDTOModif toDTO(AirPlanePage airPlanePage) {
        return modelMapper.map(airPlanePage, AirPlaneDTOModif.class);
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlanePage> airPlanePageList) {
        return Optional.ofNullable(airPlanePageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlanePage> toPage(List<AirPlaneDTOModif> airPlaneDTOModifList) {
        return Optional.ofNullable(airPlaneDTOModifList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public AirPlanePage toPage(AirPlaneDTOModif airPlaneDTOModif) {
        return modelMapper.map(airPlaneDTOModif, AirPlanePage.class);
    }
}
