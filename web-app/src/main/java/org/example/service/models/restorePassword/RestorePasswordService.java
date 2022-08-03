package org.example.service.models.restorePassword;

import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.model.Login;

public interface RestorePasswordService {
    Login restorePassword(UserProfileDTOModif2 userProfileDTOModif2, Login login);
}
