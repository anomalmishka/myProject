package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.model.UserOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperModif {
    private final ModelMapper modelMapper;

    public UserOrderDTOModif toDTO(UserOrder userOrder) {
        return modelMapper.map(userOrder, UserOrderDTOModif.class);
    }

    public List<UserOrderDTOModif> toDTO(List<UserOrder> userOrderList) {
        return Optional.ofNullable(userOrderList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserOrder> toModel(List<UserOrderDTOModif> userOrderDTOModifList) {
        return Optional.ofNullable(userOrderDTOModifList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public UserOrder toModel(UserOrderDTOModif userOrderDTOModif) {
        return modelMapper.map(userOrderDTOModif, UserOrder.class);
    }
}
