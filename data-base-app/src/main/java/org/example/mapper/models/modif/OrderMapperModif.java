package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.OrderDTOModif;
import org.example.mapper.models.TicketMapper;
import org.example.model.entity.UserOrder;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OrderMapperModif {
    private final TicketMapper ticketMapper;


    public OrderDTOModif toDTO(UserOrder userOrder) {
        return OrderDTOModif.builder()
                .id(userOrder.getId())
                .isActive(userOrder.getIsActive())
                .ticketDTOList(ticketMapper.toDTO(userOrder.getTicketList()))
                .build();
    }

    public List<OrderDTOModif> toDTO(List<UserOrder> userOrderList) {
        return userOrderList.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<UserOrder> toModel(List<OrderDTOModif> orderDTOModifList) {
        return orderDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserOrder toModel(OrderDTOModif orderDTOModif) {
        return UserOrder.builder()
                .id(orderDTOModif.getId())
                .isActive(orderDTOModif.getIsActive())
                .ticketList(ticketMapper.toModel(orderDTOModif.getTicketDTOList()))
                .build();
    }
}
