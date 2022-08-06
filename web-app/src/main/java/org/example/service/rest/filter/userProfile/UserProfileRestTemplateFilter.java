package org.example.service.rest.filter.userProfile;


import org.example.dto.models.modif.UserProfileDTOModif;

public interface UserProfileRestTemplateFilter {
    UserProfileDTOModif findWhereNameLastnameEmail(UserProfileDTOModif userProfileDTOModif);

    UserProfileDTOModif findWhereUserId(Long userId);

}
