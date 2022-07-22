package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.mapper.models.FlightRouteMapper;
import org.example.mapper.models.PassengerProfileMapper;
import org.example.mapper.models.StatusMapper;
import org.example.model.entity.UserOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperModif {
    private final FlightRouteMapper flightRouteMapper;
    private final PassengerProfileMapper passengerProfileMapper;
    private final StatusMapper statusMapper;

    public UserOrderDTOModif toDTO(UserOrder userOrder) {
        return UserOrderDTOModif.builder()
                .id(userOrder.getId())
                .flightRouteDTO(flightRouteMapper.toDTO(userOrder.getFlightRoute()))
                .passengerProfileDTO(passengerProfileMapper.toDTO(userOrder.getPassengerProfile()))
                .statusDTO(statusMapper.toDTO(userOrder.getStatus()))
                .build();
    }

    public List<UserOrderDTOModif> toDTO(List<UserOrder> userOrderList) {
        return userOrderList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserOrder> toModel(List<UserOrderDTOModif> userOrderDTOModifList) {
        return userOrderDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserOrder toModel(UserOrderDTOModif userOrderDTOModif) {
        return UserOrder.builder()
                .id(userOrderDTOModif.getId())
                .flightRoute(flightRouteMapper.toModel(userOrderDTOModif.getFlightRouteDTO()))
                .passengerProfile(passengerProfileMapper.toModel(userOrderDTOModif.getPassengerProfileDTO()))
                .status(statusMapper.toModel(userOrderDTOModif.getStatusDTO()))
                .build();
    }
}
