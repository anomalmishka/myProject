package org.example.mapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.mapper.model.BankCardMapper;
import org.example.mapper.model.PassengerProfileMapper;
import org.example.model.obj.database.modif.UserProfileModif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperModif {
    private final BankCardMapper bankCardMapper;
    private final PassengerProfileMapper passengerProfileMapper;

    public UserProfileDTOModif toDTO(UserProfileModif userProfileModif) {
        return UserProfileDTOModif.builder()
                .id(userProfileModif.getId())
                .name(userProfileModif.getName())
                .lastname(userProfileModif.getLastname())
                .phone(userProfileModif.getPhone())
                .email(userProfileModif.getEmail())
                .isBlockedProfile(userProfileModif.getIsBlockedProfile())
                .userId(userProfileModif.getUserId())
                .bankCardDTOList(bankCardMapper.toDTO(userProfileModif.getBankCardList()))
                .passengerProfileDTOList(passengerProfileMapper.toDTO(userProfileModif.getPassengerProfileList()))
                .build();
    }

    public List<UserProfileDTOModif> toDTO(List<UserProfileModif> userProfileModifList) {
        return userProfileModifList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<UserProfileModif> toModel(List<UserProfileDTOModif> userProfileDTOModifList) {
        return userProfileDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserProfileModif toModel(UserProfileDTOModif userProfileDTOModif) {
        return UserProfileModif.builder()
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
