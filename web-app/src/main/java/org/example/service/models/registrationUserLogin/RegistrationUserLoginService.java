package org.example.service.models.registrationUserLogin;

import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserLogin;

public interface RegistrationUserLoginService {
    UserProfileDTOModif create(UserProfileDTOModif userProfileDTOModif2, UserLogin userLogin);

    UserProfileDTOModif update(UserProfileDTOModif userProfileDTOModif2, UserLogin userLogin);
    UserProfileDTOModif readById(UserProfileDTOModif userProfileDTOModif2, UserLogin userLogin);
}
