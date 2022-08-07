package org.example.service.models.userProfilePage;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfile.UserProfileService;
import org.example.service.models.userProfileCustom.UserProfileCustomService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class UserProfilePageServiceImpl implements UserProfilePageService {
    private final UserProfileCustomService userProfileCustomService;
    private final UserProfileService userProfileService;
    private final UserLoginCustomService userLoginCustomService;

    @Override
    public UserProfileDTOModif findWhereName(Principal principal) {
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        return userProfileCustomService.findWhereUserId(loginId);
    }

    @Override
    public UserProfileDTOModif updateProfile(UserProfileDTOModif userProfileDTOModif, Principal principal) {
        List<PassengerProfileDTOModif> getPassengerProfileList = userProfileDTOModif.getPassengerProfileList();
        List<BankCardDTO> getBankCardList = userProfileDTOModif.getBankCardList();
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOModif findUserProfileDTOModif = userProfileCustomService.findWhereUserId(loginId);
        findUserProfileDTOModif.setProfilename(userProfileDTOModif.getProfilename());
        findUserProfileDTOModif.setLastname(userProfileDTOModif.getLastname());
        findUserProfileDTOModif.setPhone(userProfileDTOModif.getPhone());
        findUserProfileDTOModif.setEmail(userProfileDTOModif.getEmail());
        System.out.println(getPassengerProfileList);
        if (getPassengerProfileList != null) {
            findUserProfileDTOModif.setPassengerProfileList(getPassengerProfileList);
        }
        if (getBankCardList != null) {
            findUserProfileDTOModif.setBankCardList(getBankCardList);
        }
        return userProfileService.update(findUserProfileDTOModif);
    }
}
