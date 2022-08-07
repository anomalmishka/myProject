package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneFlightRouteDTOModif;
import org.example.dto.page.AirPlaneFlightRoutePage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneFlightRouteMapperPage {
    private final ModelMapper modelMapper;

    public AirPlaneFlightRouteDTOModif toDTO(AirPlaneFlightRoutePage airPlaneFlightRoutePage) {
        return modelMapper.map(airPlaneFlightRoutePage, AirPlaneFlightRouteDTOModif.class);
    }

    public List<AirPlaneFlightRouteDTOModif> toDTO(List<AirPlaneFlightRoutePage> airPlaneFlightRoutePageList) {
        return Optional.ofNullable(airPlaneFlightRoutePageList)
                .map(list -> list
                        .stream().map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirPlaneFlightRoutePage> toPage(List<AirPlaneFlightRouteDTOModif> airPlaneFlightRouteDTOModifList) {
        return Optional.ofNullable(airPlaneFlightRouteDTOModifList)
                .map(list -> list
                        .stream().map(this::toPage).collect(Collectors.toList())).orElse(null);
    }
    public AirPlaneFlightRoutePage toPage(AirPlaneFlightRouteDTOModif airPlaneFlightRouteDTOModif) {
        return modelMapper.map(airPlaneFlightRouteDTOModif, AirPlaneFlightRoutePage.class);
    }
}
