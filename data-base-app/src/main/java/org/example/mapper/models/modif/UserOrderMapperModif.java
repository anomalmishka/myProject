package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.UserOrderDTOModif;
import org.example.mapper.models.FlightRouteMapper;
import org.example.mapper.models.StatusMapper;
import org.example.model.entity.UserOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperModif {
    private final StatusMapper statusMapper;
    private final FlightRouteMapper flightRouteMapperflightRouteMapper;

    public UserOrderDTOModif toDTO(UserOrder userOrder) {
        return UserOrderDTOModif.builder()
                .id(userOrder.getId())
                .flightRouteDTO(flightRouteMapperflightRouteMapper.toDTO(userOrder.getFlightRoute()))
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
                .flightRoute(flightRouteMapperflightRouteMapper.toModel(userOrderDTOModif.getFlightRouteDTO()))
                .status(statusMapper.toModel(userOrderDTOModif.getStatusDTO()))
                .build();
    }
}
