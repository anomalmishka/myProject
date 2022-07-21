package org.example.mapper.models;

import org.example.dto.models.UserOrderDTO;
import org.example.model.entity.UserOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserOrderMapper {
    public UserOrderDTO toDTO(UserOrder userOrder) {
        return UserOrderDTO.builder()
                .id(userOrder.getId())
                .status(userOrder.getStatus())
                .build();
    }

    public List<UserOrderDTO> toDTO(List<UserOrder> userOrderList) {
        return userOrderList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserOrder> toModel(List<UserOrderDTO> ticketDTOS) {
        return ticketDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserOrder toModel(UserOrderDTO userOrderDTO) {
        return UserOrder.builder()
                .id(userOrderDTO.getId())
                .status(userOrderDTO.getStatus())
                .build();
    }
}