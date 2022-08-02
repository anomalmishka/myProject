package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.PassengerProfileDTOModif2;
import org.example.dto.page.modelPage.PassengerProfilePage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperPage {
    private final UserOrderMapperPage userOrderMapperPage;

    public PassengerProfileDTOModif2 toDTO(PassengerProfilePage passengerProfilePage) {
        return PassengerProfileDTOModif2.builder()
                .id(passengerProfilePage.getId())
                .name(passengerProfilePage.getName())
                .lastname(passengerProfilePage.getLastname())
                .passportNumber(passengerProfilePage.getPassportNumber())
                .userOrderDTOModif2List(userOrderMapperPage.toDTO(passengerProfilePage.getUserOrderPageList()))
                .build();
    }

    public List<PassengerProfileDTOModif2> toDTO(List<PassengerProfilePage> passengerProfilePageList) {
        return Optional.ofNullable(passengerProfilePageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfilePage> toPage(List<PassengerProfileDTOModif2> passengerProfileDTOModif2List) {
        return Optional.ofNullable(passengerProfileDTOModif2List)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfilePage toPage(PassengerProfileDTOModif2 passengerProfileDTOModif2) {
        return PassengerProfilePage.builder()
                .id(passengerProfileDTOModif2.getId())
                .name(passengerProfileDTOModif2.getName())
                .lastname(passengerProfileDTOModif2.getLastname())
                .passportNumber(passengerProfileDTOModif2.getPassportNumber())
                .userOrderPageList(userOrderMapperPage.toPage(passengerProfileDTOModif2.getUserOrderDTOModif2List()))
                .build();
    }
}
