package org.example.mapper.models.modif2;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.mapper.models.BankCardMapper;
import org.example.model.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperModif2 {
    private final BankCardMapper bankCardMapper;
    private final PassengerProfileMapperModif2 passengerProfileMapperModif2;

    public UserProfileDTOModif2 toDTO(UserProfile userProfile) {
        return UserProfileDTOModif2.builder()
                .id(userProfile.getId())
                .name(userProfile.getName())
                .lastname(userProfile.getLastname())
                .phone(userProfile.getPhone())
                .email(userProfile.getEmail())
                .isBlockedProfile(userProfile.getIsBlockedProfile())
                .userId(userProfile.getUserId())
                .bankCardDTOList(bankCardMapper.toDTO(userProfile.getBankCardList()))
                .passengerProfileDTOModif2List(passengerProfileMapperModif2.toDTO(userProfile.getPassengerProfileList()))
                .build();
    }

    public List<UserProfileDTOModif2> toDTO(List<UserProfile> userProfileList) {
        return userProfileList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserProfile> toModel(List<UserProfileDTOModif2> userProfileDTOModif2List) {
        return userProfileDTOModif2List.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserProfile toModel(UserProfileDTOModif2 userProfileDTOModif2) {
        return UserProfile.builder()
                .id(userProfileDTOModif2.getId())
                .name(userProfileDTOModif2.getName())
                .lastname(userProfileDTOModif2.getLastname())
                .phone(userProfileDTOModif2.getPhone())
                .email(userProfileDTOModif2.getEmail())
                .isBlockedProfile(userProfileDTOModif2.getIsBlockedProfile())
                .userId(userProfileDTOModif2.getUserId())
                .bankCardList(bankCardMapper.toModel(userProfileDTOModif2.getBankCardDTOList()))
                .passengerProfileList(passengerProfileMapperModif2.toModel(userProfileDTOModif2.getPassengerProfileDTOModif2List()))
                .build();
    }
}
