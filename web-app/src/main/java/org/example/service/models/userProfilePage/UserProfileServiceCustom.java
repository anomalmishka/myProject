package org.example.service.models.userProfilePage;

import org.example.dto.models.modif.UserProfileDTOModif;

public interface UserProfileServiceCustom {
    UserProfileDTOModif findWhereNameLastnameEmail(UserProfileDTOModif userProfileDTOModif);
    UserProfileDTOModif findWhereUserId(Long userId);
}
