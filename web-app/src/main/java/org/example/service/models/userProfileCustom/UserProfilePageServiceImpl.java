package org.example.service.models.userProfileCustom;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfile.UserProfileService;
import org.example.service.models.userProfilePage.UserProfileServiceCustom;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

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
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOModif findUserProfileDTOModif = userProfileServiceCustom.findWhereUserId(loginId);
        findUserProfileDTOModif.setUsername(userProfileDTOModif.getUsername());
        findUserProfileDTOModif.setLastname(userProfileDTOModif.getLastname());
        findUserProfileDTOModif.setPhone(userProfileDTOModif.getPhone());
        findUserProfileDTOModif.setEmail(userProfileDTOModif.getEmail());
        System.out.println(findUserProfileDTOModif);
        return userProfileService.update(findUserProfileDTOModif);
    }

    @Override
    public List<PassengerProfileDTOModif> getPassanger(Principal principal) {
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOModif userProfileDTOModif = userProfileServiceCustom.findWhereUserId(loginId);
        return userProfileDTOModif.getPassengerProfileDTOModifList();
    }
}
