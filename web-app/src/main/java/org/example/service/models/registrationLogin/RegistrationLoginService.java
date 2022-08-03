package org.example.service.models.registrationLogin;

import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.model.Login;

public interface RegistrationLoginService {
    UserProfileDTOModif2 create(UserProfileDTOModif2 userProfileDTOModif2, Login login);

    UserProfileDTOModif2 update(UserProfileDTOModif2 userProfileDTOModif2, Login login);
    UserProfileDTOModif2 readById(UserProfileDTOModif2 userProfileDTOModif2, Login login);
}
