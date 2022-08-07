package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.BankCard;
import org.example.model.PassengerProfile;
import org.example.model.UserProfile;
import org.example.service.models.api.UserProfileService;
import org.example.service.modif.api.UserProfileServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImplModif implements UserProfileServiceModif {

    private final UserProfileService userProfileService;

    @Override
    public UserProfile create(UserProfile userProfile) {
        PassengerProfile passengerProfile = PassengerProfile.builder()
                .passengername(userProfile.getProfilename())
                .passengerlastname(userProfile.getLastname())
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
        System.out.println(userProfile);
        if (userProfile.getProfilename() != null) {
            Long id = userProfile.getId();
            UserProfile readById = userProfileService.readById(id);
            readById.setProfilename(userProfile.getProfilename());
            readById.setLastname(userProfile.getLastname());
            readById.setPhone(userProfile.getPhone());
            readById.setEmail(userProfile.getEmail());
            return readById;
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
