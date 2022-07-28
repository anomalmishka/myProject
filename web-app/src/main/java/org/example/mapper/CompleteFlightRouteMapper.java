package org.example.mapper;

import lombok.RequiredArgsConstructor;

import org.example.dto.CompleteFlightRouteDTO;
import org.example.mapper.model.AirCompanyMapper;
import org.example.mapper.model.AirPlaneMapper;
import org.example.model.database.FlightRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CompleteFlightRouteMapper {
    private final AirCompanyMapper airCompanyMapper;
    private final AirPlaneMapper airPlaneMapper;

    public List<FlightRoute> toModel(List<CompleteFlightRouteDTO> completeFlightRouteDTOList) {
        return completeFlightRouteDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FlightRoute toModel(CompleteFlightRouteDTO completeFlightRouteDTO) {
        return FlightRoute.builder()
                .build();
    }
}
