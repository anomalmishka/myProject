package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.UserProfileDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.api.BankCardService;
import org.example.service.api.PassengerProfileService;
import org.example.service.models.modif.api.UserProfileServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImplModif implements UserProfileServiceModif {

    private final UserProfileDAO userProfileDAO;
    private final BankCardService bankCardService;
    private final PassengerProfileService passengerProfileService;

    @Override
    public UserProfile create(UserProfile userProfile) {
        UserProfile verifyModel = setForgetValueOnId(userProfile);
        PassengerProfile passengerProfile = PassengerProfile.builder()
                .name(verifyModel.getName())
                .lastname(verifyModel.getLastname())
                .build();
        BankCard bankCard = BankCard.builder().build();
        verifyModel.setPassengerProfileList(List.of(passengerProfile));
        verifyModel.setBankCardList(List.of(bankCard));
        return userProfileDAO.save(verifyModel);
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        return userProfileDAO.save(setForgetValueOnId(userProfile));
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
