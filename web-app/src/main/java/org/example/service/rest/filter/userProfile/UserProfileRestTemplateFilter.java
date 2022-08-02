package org.example.service.rest.filter.userProfile;


import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;

public interface UserProfileRestTemplateFilter {
    UserProfileDTOModif2 findWhereNameLastnameEmail(UserProfileDTOModif2 userProfileDTOModif2);

}
