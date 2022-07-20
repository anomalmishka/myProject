package org.example.mapper.modelsMapper;

import org.example.dto.models.OrderDTO;
import org.example.model.entity.UserOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public OrderDTO toDTO(UserOrder userOrder) {
        return OrderDTO.builder()
                .id(userOrder.getId())
                .isActive(userOrder.getIsActive())
                .build();
    }

    public List<OrderDTO> toDTO(List<UserOrder> userOrderList) {
        return userOrderList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserOrder> toModel(List<OrderDTO> ticketDTOS) {
        return ticketDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserOrder toModel(OrderDTO ticketDTO) {
        return UserOrder.builder()
                .id(ticketDTO.getId())
                .isActive(ticketDTO.getIsActive())
                .build();
    }
}
