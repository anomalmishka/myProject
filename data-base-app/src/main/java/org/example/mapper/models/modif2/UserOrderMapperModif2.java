package org.example.mapper.models.modif2;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserOrderDTOModif2;
import org.example.mapper.models.StatusMapper;
import org.example.model.entity.UserOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperModif2 {
    private final StatusMapper statusMapper;
    private final FlightRouteMapperModif2 flightRouteMapperModif2;

    public UserOrderDTOModif2 toDTO(UserOrder userOrder) {
        return UserOrderDTOModif2.builder()
                .id(userOrder.getId())
                .flightRouteDTOModif2(flightRouteMapperModif2.toDTO(userOrder.getFlightRoute()))
                .statusDTO(statusMapper.toDTO(userOrder.getStatus()))
                .build();
    }

    public List<UserOrderDTOModif2> toDTO(List<UserOrder> userOrderList) {
        return userOrderList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserOrder> toModel(List<UserOrderDTOModif2> userOrderDTOModif2List) {
        return userOrderDTOModif2List.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserOrder toModel(UserOrderDTOModif2 userOrderDTOModif2) {
        return UserOrder.builder()
                .id(userOrderDTOModif2.getId())
                .flightRoute(flightRouteMapperModif2.toModel(userOrderDTOModif2.getFlightRouteDTOModif2()))
                .status(statusMapper.toModel(userOrderDTOModif2.getStatusDTO()))
                .build();
    }
}
