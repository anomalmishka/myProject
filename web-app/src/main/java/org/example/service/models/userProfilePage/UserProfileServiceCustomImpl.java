package org.example.service.models.userProfilePage;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.service.rest.filter.userProfile.UserProfileRestTemplateFilter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserProfileServiceCustomImpl implements UserProfileServiceCustom {
    private final UserProfileRestTemplateFilter userProfileRestTemplateFilter;

    @Override
    public UserProfileDTOModif findWhereUserId(Long userId) {
        return userProfileRestTemplateFilter.findWhereUserId(userId);
    }
}
