package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.UserOrderDTO;
import org.example.model.UserOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapper {

    private final ModelMapper modelMapper;

    public UserOrderDTO toDTO(UserOrder userOrder) {
        return modelMapper.map(userOrder, UserOrderDTO.class);
    }

    public List<UserOrderDTO> toDTO(List<UserOrder> userOrderList) {
        return Optional.ofNullable(userOrderList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserOrder> toModel(List<UserOrderDTO> userOrderDTOList) {
        return Optional.ofNullable(userOrderDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public UserOrder toModel(UserOrderDTO userOrderDTO) {
        return modelMapper.map(userOrderDTO, UserOrder.class);
    }
}
