package org.example.service.models.userProfileCustom;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.rest.filter.userProfile.UserProfileRestTemplateFilter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserProfileCustomServiceImpl implements UserProfileCustomService {
    private final UserProfileRestTemplateFilter userProfileRestTemplateFilter;
    private final UserLoginCustomService userLoginCustomService;

    @Override
    public UserProfileDTOModif findWhereUserId(Long userId) {
        return userProfileRestTemplateFilter.findWhereUserId(userId);
    }

    @Override
    public UserProfileDTOModif readUserProfile(String username) {
        UserLogin userLogin = userLoginCustomService.findByUsername(username);
        Long userLoginId = userLogin.getId();
        return findWhereUserId(userLoginId);
    }
}
