package org.example.mapper.modelsMapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.mapper.modelsMapper.BankCardMapper;
import org.example.model.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperModif {
    private final OrderMapperModif orderMapperModif;
    private final BankCardMapper bankCardMapper;

    public UserProfileDTOModif toDTO(UserProfile userProfile) {
        return UserProfileDTOModif.builder()
                .id(userProfile.getId())
                .name(userProfile.getName())
                .lastname(userProfile.getLastname())
                .phone(userProfile.getPhone())
                .email(userProfile.getEmail())
                .isBlockedProfile(userProfile.getIsBlockedProfile())
                .userId(userProfile.getUserId())
                .orderDTOModifList(orderMapperModif.toDTO(userProfile.getUserOrderList()))
                .bankCardDTOList(bankCardMapper.toDTO(userProfile.getBankCardList()))
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
                .userOrderList(orderMapperModif.toModel(userProfileDTOModif.getOrderDTOModifList()))
                .bankCardList(bankCardMapper.toModel(userProfileDTOModif.getBankCardDTOList()))
                .build();
    }
}
