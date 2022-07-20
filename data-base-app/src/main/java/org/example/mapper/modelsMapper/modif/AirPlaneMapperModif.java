package org.example.mapper.modelsMapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.model.entity.AirPlane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirPlaneMapperModif {
    private final FlightRouteMapperModif flightRouteMapperModif;
    private final SeatMapperModif seatMapperModif;

    public AirPlaneDTOModif toDTO(AirPlane airPlane) {
        return AirPlaneDTOModif.builder()
                .id(airPlane.getId())
                .type(airPlane.getType())
                .numberSeat(airPlane.getNumberSeat())
                .flightRouteDTOModifList(flightRouteMapperModif.toDTO(airPlane.getFlightRouteList()))
                .seatDTOModifList(seatMapperModif.toDTO(airPlane.getSeatList()))
                .build();
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlane> airPlanes) {
        return airPlanes.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlane> toModel(List<AirPlaneDTOModif> airPlaneDTOModifs) {
        return airPlaneDTOModifs.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlane toModel(AirPlaneDTOModif airPlaneDTOModif) {
        return AirPlane.builder()
                .id(airPlaneDTOModif.getId())
                .type(airPlaneDTOModif.getType())
                .numberSeat(airPlaneDTOModif.getNumberSeat())
                .flightRouteList(flightRouteMapperModif.toModel(airPlaneDTOModif.getFlightRouteDTOModifList()))
                .seatList(seatMapperModif.toModel(airPlaneDTOModif.getSeatDTOModifList()))
                .build();
    }
}
