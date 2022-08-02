package org.example.mapper.models.modif2;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.PassengerProfileDTOModif2;
import org.example.model.entity.PassengerProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperModif2 {
    private final UserOrderMapperModif2 userOrderMapperModif2;

    public PassengerProfileDTOModif2 toDTO(PassengerProfile passengerProfile) {
        return PassengerProfileDTOModif2.builder()
                .id(passengerProfile.getId())
                .name(passengerProfile.getName())
                .lastname(passengerProfile.getLastname())
                .passportNumber(passengerProfile.getPassportNumber())
                .userOrderDTOModif2List(userOrderMapperModif2.toDTO(passengerProfile.getUserOrderList()))
                .build();
    }

    public List<PassengerProfileDTOModif2> toDTO(List<PassengerProfile> passengerProfileList) {
        return passengerProfileList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTOModif2> passengerProfileDTOModif2List) {
        return passengerProfileDTOModif2List.stream().map(this::toModel).collect(Collectors.toList());
    }

    public PassengerProfile toModel(PassengerProfileDTOModif2 passengerProfileDTOModif2) {
        return PassengerProfile.builder()
                .id(passengerProfileDTOModif2.getId())
                .name(passengerProfileDTOModif2.getName())
                .lastname(passengerProfileDTOModif2.getLastname())
                .passportNumber(passengerProfileDTOModif2.getPassportNumber())
                .userOrderList(userOrderMapperModif2.toModel(passengerProfileDTOModif2.getUserOrderDTOModif2List()))
                .build();
    }
}
