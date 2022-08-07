package org.example.service.models.userProfilePage;

import org.example.dto.models.modif.UserProfileDTOModif;
import java.security.Principal;

public interface UserProfilePageService {
    UserProfileDTOModif findWhereName(Principal principal);

    UserProfileDTOModif updateProfile(UserProfileDTOModif userProfileDTOModif, Principal principal);
}
