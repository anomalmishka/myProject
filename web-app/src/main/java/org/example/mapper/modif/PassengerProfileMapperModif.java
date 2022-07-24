package org.example.mapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.mapper.model.UserOrderMapper;
import org.example.mapper.model.UserProfileMapper;
import org.example.model.obj.database.modif.PassengerProfileModif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperModif {
    private final UserProfileMapper userProfileMapper;
    private final UserOrderMapper userOrderMapper;

    public PassengerProfileDTOModif toDTO(PassengerProfileModif passengerProfileModif) {
        return PassengerProfileDTOModif.builder()
                .id(passengerProfileModif.getId())
                .name(passengerProfileModif.getName())
                .lastname(passengerProfileModif.getLastname())
                .passportNumber(passengerProfileModif.getPassportNumber())
                .userProfileDTO(userProfileMapper.toDTO(passengerProfileModif.getUserProfile()))
                .userOrderDTOList(userOrderMapper.toDTO(passengerProfileModif.getUserOrderList()))
                .build();
    }

    public List<PassengerProfileDTOModif> toDTO(List<PassengerProfileModif> passengerProfileModifList) {
        return passengerProfileModifList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PassengerProfileModif> toModel(List<PassengerProfileDTOModif> passengerProfileDTOModifList) {
        return passengerProfileDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public PassengerProfileModif toModel(PassengerProfileDTOModif passengerProfileDTOModif) {
        return PassengerProfileModif.builder()
                .id(passengerProfileDTOModif.getId())
                .name(passengerProfileDTOModif.getName())
                .lastname(passengerProfileDTOModif.getLastname())
                .passportNumber(passengerProfileDTOModif.getPassportNumber())
                .userProfile(userProfileMapper.toModel(passengerProfileDTOModif.getUserProfileDTO()))
                .userOrderList(userOrderMapper.toModel(passengerProfileDTOModif.getUserOrderDTOList()))
                .build();
    }
}
