package org.example.service.models.registrationUser;

import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.model.User;

public interface RegistrationUserService {
    UserProfileDTOModif2 create(UserProfileDTOModif2 userProfileDTOModif2, User user);

    UserProfileDTOModif2 update(UserProfileDTOModif2 userProfileDTOModif2, User user);
    UserProfileDTOModif2 readById(UserProfileDTOModif2 userProfileDTOModif2, User user);
}
