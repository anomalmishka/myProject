package org.example.service.rest.models.UserProfile;

import org.example.dto.models.modif.UserProfileDTOModif;

import java.util.List;

public interface UserProfileRestTemlateService {
    List<UserProfileDTOModif> readAll();

    UserProfileDTOModif readById(Long id);

    List<UserProfileDTOModif> readAllByIds(List<Long> ids);

    UserProfileDTOModif create(UserProfileDTOModif userProfileDTOModif);

    UserProfileDTOModif update(UserProfileDTOModif userProfileDTOModif);

    UserProfileDTOModif deleteById(Long id);

    List<UserProfileDTOModif> deleteAllByIds(List<Long> ids);
}
