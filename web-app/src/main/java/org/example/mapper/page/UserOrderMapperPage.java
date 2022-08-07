package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.dto.page.UserOrderPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperPage {
    private final ModelMapper modelMapper;

    public UserOrderDTOModif toDTO(UserOrderPage userOrderPage) {
        return modelMapper.map(userOrderPage, UserOrderDTOModif.class);

    }

    public List<UserOrderDTOModif> toDTO(List<UserOrderPage> userOrderPageList) {
        return Optional.ofNullable(userOrderPageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserOrderPage> toPage(List<UserOrderDTOModif> userOrderDTOModifList) {
        return Optional.ofNullable(userOrderDTOModifList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public UserOrderPage toPage(UserOrderDTOModif userOrderDTOModif) {
        return modelMapper.map(userOrderDTOModif, UserOrderPage.class);
    }
}
