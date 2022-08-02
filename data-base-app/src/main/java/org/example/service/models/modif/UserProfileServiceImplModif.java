package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.BankCardService;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.models.api.UserProfileService;
import org.example.service.models.modif.api.UserProfileServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImplModif implements UserProfileServiceModif {

    private final UserProfileService userProfileService;
    private final BankCardService bankCardService;
    private final PassengerProfileService passengerProfileService;

    @Override
    public UserProfile create(UserProfile userProfile) {
        PassengerProfile passengerProfile = PassengerProfile.builder()
                .name(userProfile.getName())
                .lastname(userProfile.getLastname())
                .build();
        BankCard bankCard = BankCard.builder().build();
        userProfile.setPassengerProfileList(List.of(passengerProfile));
        userProfile.setBankCardList(List.of(bankCard));
        return userProfileService.create(userProfile);
    }

    @Override
    public List<UserProfile> readAll() {
        return userProfileService.readAll();
    }

    @Override
    public UserProfile readById(Long id) {
        return userProfileService.readById(id);
    }

    @Override
    public List<UserProfile> readAllByIds(List<Long> ids) {
        return userProfileService.readAllByIds(ids);
    }

    @Override
    public UserProfile deleteById(Long id) {
        return userProfileService.deleteById(id);
    }

    @Override
    public List<UserProfile> deleteAllByIds(List<Long> ids) {
        return userProfileService.deleteAllByIds(ids);
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        return userProfileService.update(setForgetValueOnId(userProfile));
    }

    private UserProfile setForgetValueOnId(UserProfile userProfile) {
        if (userProfile.getName() != null) {
            List<Long> bankCardIdList = userProfile.getBankCardList().stream().map(BankCard::getId).collect(Collectors.toList());
            List<BankCard> bankCardList = bankCardService.readAllByIds(bankCardIdList);
            userProfile.setBankCardList(bankCardList);
            List<Long> passengerProfileIdList = userProfile.getPassengerProfileList().stream().map(PassengerProfile::getId).collect(Collectors.toList());
            List<PassengerProfile> passengerProfileList = passengerProfileService.readAllByIds(passengerProfileIdList);
            userProfile.setPassengerProfileList(passengerProfileList);
            return userProfile;
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
