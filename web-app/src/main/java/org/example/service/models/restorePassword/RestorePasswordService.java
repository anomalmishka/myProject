package org.example.service.models.restorePassword;

import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.model.User;

public interface RestorePasswordService {
    User restorePassword(UserProfileDTOModif2 userProfileDTOModif2, User user);
}
