package org.example.service.models.userProfileCustom;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfile.UserProfileService;
import org.example.service.models.userProfilePage.UserProfileServiceCustom;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class UserProfilePageServiceImpl implements UserProfilePageService {
    private final UserProfileServiceCustom userProfileServiceCustom;
    private final UserProfileService userProfileService;
    private final UserLoginCustomService userLoginCustomService;

    @Override
    public UserProfileDTOModif findWhereName(Principal principal) {
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        return userProfileServiceCustom.findWhereUserId(loginId);
    }

    @Override
    public UserProfileDTOModif updateProfile(UserProfileDTOModif userProfileDTOModif, Principal principal) {
        List<PassengerProfileDTOModif> getPassengerProfileList = userProfileDTOModif.getPassengerProfileList();
        List<BankCardDTO> getBankCardList = userProfileDTOModif.getBankCardList();
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOModif findUserProfileDTOModif = userProfileServiceCustom.findWhereUserId(loginId);
        List<PassengerProfileDTOModif> findPassengerProfileList = findUserProfileDTOModif.getPassengerProfileList();
        List<BankCardDTO> findBankCardList = findUserProfileDTOModif.getBankCardList();
        findUserProfileDTOModif.setProfilename(userProfileDTOModif.getProfilename());
        findUserProfileDTOModif.setLastname(userProfileDTOModif.getLastname());
        findUserProfileDTOModif.setPhone(userProfileDTOModif.getPhone());
        findUserProfileDTOModif.setEmail(userProfileDTOModif.getEmail());
        findUserProfileDTOModif.setPassengerProfileList(
                Stream.concat(findPassengerProfileList.stream(), getPassengerProfileList.stream()).parallel()
                .collect(Collectors.toList()));
        findUserProfileDTOModif.setBankCardList(
                Stream.concat(findBankCardList.stream(), getBankCardList.stream()).parallel()
                        .collect(Collectors.toList()));
        return userProfileService.update(findUserProfileDTOModif);
    }

    @Override
    public List<PassengerProfileDTOModif> getPassanger(Principal principal) {
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOModif userProfileDTOModif = userProfileServiceCustom.findWhereUserId(loginId);
        return userProfileDTOModif.getPassengerProfileList();
    }
}
