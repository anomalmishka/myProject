package org.example.mapper.model.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.mapper.model.UserOrderMapper;
import org.example.mapper.model.UserProfileMapper;
import org.example.model.database.PassengerProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperModif {
    private final UserProfileMapper userProfileMapper;
    private final UserOrderMapper userOrderMapper;

    public PassengerProfileDTOModif toDTO(PassengerProfile passengerProfile) {
        return PassengerProfileDTOModif.builder()
                .id(passengerProfile.getId())
                .name(passengerProfile.getName())
                .lastname(passengerProfile.getLastname())
                .passportNumber(passengerProfile.getPassportNumber())
                .userProfileDTO(userProfileMapper.toDTO(passengerProfile.getUserProfile()))
                .userOrderDTOList(userOrderMapper.toDTO(passengerProfile.getUserOrderList()))
                .build();
    }

    public List<PassengerProfileDTOModif> toDTO(List<PassengerProfile> passengerProfileList) {
        return passengerProfileList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTOModif> passengerProfileDTOModifList) {
        return passengerProfileDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public PassengerProfile toModel(PassengerProfileDTOModif passengerProfileDTOModif) {
        return PassengerProfile.builder()
                .id(passengerProfileDTOModif.getId())
                .name(passengerProfileDTOModif.getName())
                .lastname(passengerProfileDTOModif.getLastname())
                .passportNumber(passengerProfileDTOModif.getPassportNumber())
                .userProfile(userProfileMapper.toModel(passengerProfileDTOModif.getUserProfileDTO()))
                .userOrderList(userOrderMapper.toModel(passengerProfileDTOModif.getUserOrderDTOList()))
                .build();
    }
}
