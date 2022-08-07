package org.example.service.rest.filter.userProfile;


import org.example.dto.models.modif.UserProfileDTOModif;

public interface UserProfileRestTemplateFilter {

    UserProfileDTOModif findWhereUserId(Long userId);

}
