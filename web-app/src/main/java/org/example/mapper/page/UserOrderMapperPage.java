package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserOrderDTOModif2;
import org.example.dto.page.modelPage.UserOrderPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperPage {
    private final StatusMapperPage statusMapperPage;
    private final FlightRouteMapperPage flightRouteMapperPage;

    public UserOrderDTOModif2 toDTO(UserOrderPage userOrderPage) {
        return UserOrderDTOModif2.builder()
                .id(userOrderPage.getId())
                .flightRouteDTOModif2(flightRouteMapperPage.toDTO(userOrderPage.getFlightRoutePage()))
                .statusDTO(statusMapperPage.toDTO(userOrderPage.getStatusPage()))
                .build();
    }

    public List<UserOrderDTOModif2> toDTO(List<UserOrderPage> userOrderPageList) {
        return Optional.ofNullable(userOrderPageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserOrderPage> toPage(List<UserOrderDTOModif2> userOrderDTOModif2List) {
        return Optional.ofNullable(userOrderDTOModif2List)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public UserOrderPage toPage(UserOrderDTOModif2 userOrderDTOModif2) {
        return UserOrderPage.builder()
                .id(userOrderDTOModif2.getId())
                .flightRoutePage(flightRouteMapperPage.toPage(userOrderDTOModif2.getFlightRouteDTOModif2()))
                .statusPage(statusMapperPage.toPage(userOrderDTOModif2.getStatusDTO()))
                .build();
    }
}
