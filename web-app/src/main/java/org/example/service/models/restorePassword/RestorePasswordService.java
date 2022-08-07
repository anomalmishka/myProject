package org.example.service.models.restorePassword;

import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserLogin;

public interface RestorePasswordService {
    UserLogin restorePassword(UserProfileDTOModif userProfileDTOModif2, UserLogin userLogin);
}
