package org.example.service.models.userProfilePage;

import org.example.dto.models.modif.UserProfileDTOModif;

public interface UserProfileServiceCustom {
    UserProfileDTOModif findWhereUserId(Long userId);
}
