package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.dto.page.FlightRoutePage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperPage {
    private final ModelMapper modelMapper;

    public FlightRouteDTOModif toDTO(FlightRoutePage flightRoutePage) {
        return modelMapper.map(flightRoutePage, FlightRouteDTOModif.class);
    }

    public List<FlightRouteDTOModif> toDTO(List<FlightRoutePage> flightRoutePageList) {
        return Optional.ofNullable(flightRoutePageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }


    public List<FlightRoutePage> toPage(List<FlightRouteDTOModif> flightRouteDTOModifList) {
        return Optional.ofNullable(flightRouteDTOModifList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public FlightRoutePage toPage(FlightRouteDTOModif flightRouteDTOModif) {
        return modelMapper.map(flightRouteDTOModif, FlightRoutePage.class);
    }
}