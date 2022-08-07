package org.example.service.models.userProfileCustom;

import org.example.dto.models.modif.UserProfileDTOModif;

public interface UserProfileCustomService {
    UserProfileDTOModif findWhereUserId(Long userId);
}
