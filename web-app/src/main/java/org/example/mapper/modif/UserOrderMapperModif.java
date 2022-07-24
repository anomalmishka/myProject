package org.example.mapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.mapper.model.FlightRouteMapper;
import org.example.mapper.model.PassengerProfileMapper;
import org.example.mapper.model.StatusMapper;
import org.example.model.obj.database.modif.UserOrderModif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperModif {
    private final FlightRouteMapper flightRouteMapper;
    private final PassengerProfileMapper passengerProfileMapper;
    private final StatusMapper statusMapper;

    public UserOrderDTOModif toDTO(UserOrderModif userOrderModif) {
        return UserOrderDTOModif.builder()
                .id(userOrderModif.getId())
                .flightRouteDTO(flightRouteMapper.toDTO(userOrderModif.getFlightRoute()))
                .passengerProfileDTO(passengerProfileMapper.toDTO(userOrderModif.getPassengerProfile()))
                .statusDTO(statusMapper.toDTO(userOrderModif.getStatus()))
                .build();
    }

    public List<UserOrderDTOModif> toDTO(List<UserOrderModif> userOrderModifList) {
        return userOrderModifList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserOrderModif> toModel(List<UserOrderDTOModif> userOrderDTOModifList) {
        return userOrderDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserOrderModif toModel(UserOrderDTOModif userOrderDTOModif) {
        return UserOrderModif.builder()
                .id(userOrderDTOModif.getId())
                .flightRoute(flightRouteMapper.toModel(userOrderDTOModif.getFlightRouteDTO()))
                .passengerProfile(passengerProfileMapper.toModel(userOrderDTOModif.getPassengerProfileDTO()))
                .status(statusMapper.toModel(userOrderDTOModif.getStatusDTO()))
                .build();
    }
}
