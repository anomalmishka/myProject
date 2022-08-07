package org.example.service.models.passengerProfileCustom;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfileCustom.UserProfileCustomService;
import org.example.service.models.userProfilePage.UserProfilePageService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerProfileCustomServiceImpl implements PassengerProfileCustomService {

    private final UserProfilePageService userProfilePageService;
    private final UserLoginCustomService userLoginCustomService;
    private final UserProfileCustomService userProfileCustomService;

    @Override
    public List<PassengerProfileDTOModif> create(PassengerProfileDTOModif passengerProfileDTOModif, Principal principal) {
        String name = principal.getName();
        UserLogin userLogin = userLoginCustomService.findByUsername(name);
        Long userLoginId = userLogin.getId();
        UserProfileDTOModif findUserProfileDTOModif = userProfileCustomService.findWhereUserId(userLoginId);
        List<PassengerProfileDTOModif> getPassengerProfileDTOModifList = findUserProfileDTOModif.getPassengerProfileList();
        if (passengerProfileDTOModif != null) {
            getPassengerProfileDTOModifList.add(passengerProfileDTOModif);
        }
        findUserProfileDTOModif.setPassengerProfileList(getPassengerProfileDTOModifList);
        UserProfileDTOModif updateUserProfileDTOModif = userProfilePageService.updateProfile(findUserProfileDTOModif, principal);
        return updateUserProfileDTOModif.getPassengerProfileList();
    }

    @Override
    public List<PassengerProfileDTOModif> getPassanger(Principal principal) {
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOModif userProfileDTOModif = userProfileCustomService.findWhereUserId(loginId);
        return userProfileDTOModif.getPassengerProfileList();
    }
}
