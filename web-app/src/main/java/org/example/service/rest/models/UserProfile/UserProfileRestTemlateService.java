package org.example.service.rest.models.UserProfile;

import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;

import java.util.List;

public interface UserProfileRestTemlateService {
    List<UserProfileDTOModif2> readAll();

    UserProfileDTOModif2 readById(Long id);

    List<UserProfileDTOModif2> readAllByIds(List<Long> ids);

    UserProfileDTOModif2 create(UserProfileDTOModif2 userProfileDTOModif2);

    UserProfileDTOModif2 update(UserProfileDTOModif2 userProfileDTOModif2);

    UserProfileDTOModif2 deleteById(Long id);

    List<UserProfileDTOModif2> deleteAllByIds(List<Long> ids);
}
