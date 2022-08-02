package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.dto.page.modelPage.UserProfilePage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperPage {
    private final BankCardMapperPage bankCardMapper;
    private final PassengerProfileMapperPage passengerProfileMapperModif2;


    public UserProfileDTOModif2 toDTO(UserProfilePage userProfilePage) {
        return UserProfileDTOModif2.builder()
                .id(userProfilePage.getId())
                .name(userProfilePage.getName())
                .lastname(userProfilePage.getLastname())
                .phone(userProfilePage.getPhone())
                .email(userProfilePage.getEmail())
                .isBlockedProfile(userProfilePage.getIsBlockedProfile())
                .userId(userProfilePage.getUserId())
                .bankCardDTOList(bankCardMapper.toDTO(userProfilePage.getBankCardPageList()))
                .passengerProfileDTOModif2List(passengerProfileMapperModif2.toDTO(userProfilePage.getPassengerProfilePageList()))
                .build();
    }

    public List<UserProfileDTOModif2> toDTO(List<UserProfilePage> userProfilePageList) {
        return Optional.ofNullable(userProfilePageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserProfilePage> toPage(List<UserProfileDTOModif2> userProfileDTOModif2List) {
        return Optional.ofNullable(userProfileDTOModif2List)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public UserProfilePage toPage(UserProfileDTOModif2 userProfileDTOModif2) {
        return UserProfilePage.builder()
                .id(userProfileDTOModif2.getId())
                .name(userProfileDTOModif2.getName())
                .lastname(userProfileDTOModif2.getLastname())
                .phone(userProfileDTOModif2.getPhone())
                .email(userProfileDTOModif2.getEmail())
                .isBlockedProfile(userProfileDTOModif2.getIsBlockedProfile())
                .userId(userProfileDTOModif2.getUserId())
                .bankCardPageList(bankCardMapper.toPage(userProfileDTOModif2.getBankCardDTOList()))
                .passengerProfilePageList(passengerProfileMapperModif2.toPage(userProfileDTOModif2.getPassengerProfileDTOModif2List()))
                .build();
    }
}
