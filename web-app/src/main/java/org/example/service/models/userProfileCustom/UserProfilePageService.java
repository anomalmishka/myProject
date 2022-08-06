package org.example.service.models.userProfileCustom;

import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;

import java.security.Principal;
import java.util.List;

public interface UserProfilePageService {
    UserProfileDTOModif findWhereName(Principal principal);

    UserProfileDTOModif updateProfile(UserProfileDTOModif userProfileDTOModif, Principal principal);

    List<PassengerProfileDTOModif> getPassanger(Principal principal);
}
