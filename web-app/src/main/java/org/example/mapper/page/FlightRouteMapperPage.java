package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.dto.models.page.FlightRouteDTOModifPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightRouteMapperPage {

    public FlightRouteDTOModifPage toPageDTO(FlightRouteDTOModif flightRouteDTOModif) {

        return FlightRouteDTOModifPage.builder().build();

    }

    public List<FlightRouteDTOModifPage> toPageDTO(List<FlightRouteDTOModif> flightRouteDTOModifList) {
        return flightRouteDTOModifList.stream().map(this::toPageDTO).collect(Collectors.toList());
    }
}
