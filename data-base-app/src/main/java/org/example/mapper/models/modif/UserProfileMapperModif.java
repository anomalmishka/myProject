package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.UserProfileDTOModif;
import org.example.mapper.models.BankCardMapper;
import org.example.mapper.models.PassengerProfileMapper;
import org.example.model.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperModif {
    private final BankCardMapper bankCardMapper;
    private final PassengerProfileMapper passengerProfileMapper;

    public UserProfileDTOModif toDTO(UserProfile userProfile) {
        return UserProfileDTOModif.builder()
                .id(userProfile.getId())
                .name(userProfile.getName())
                .lastname(userProfile.getLastname())
                .phone(userProfile.getPhone())
                .email(userProfile.getEmail())
                .isBlockedProfile(userProfile.getIsBlockedProfile())
                .userId(userProfile.getUserId())
                .bankCardDTOList(bankCardMapper.toDTO(userProfile.getBankCardList()))
                .passengerProfileDTOList(passengerProfileMapper.toDTO(userProfile.getPassengerProfileList()))
                .build();
    }

    public List<UserProfileDTOModif> toDTO(List<UserProfile> userProfileList) {
        return userProfileList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserProfile> toModel(List<UserProfileDTOModif> userProfileDTOModifList) {
        return userProfileDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserProfile toModel(UserProfileDTOModif userProfileDTOModif) {
        return UserProfile.builder()
                .id(userProfileDTOModif.getId())
                .name(userProfileDTOModif.getName())
                .lastname(userProfileDTOModif.getLastname())
                .phone(userProfileDTOModif.getPhone())
                .email(userProfileDTOModif.getEmail())
                .isBlockedProfile(userProfileDTOModif.getIsBlockedProfile())
                .userId(userProfileDTOModif.getUserId())
                .bankCardList(bankCardMapper.toModel(userProfileDTOModif.getBankCardDTOList()))
                .passengerProfileList(passengerProfileMapper.toModel(userProfileDTOModif.getPassengerProfileDTOList()))
                .build();
    }
}
