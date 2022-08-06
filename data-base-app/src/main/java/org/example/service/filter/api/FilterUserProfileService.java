package org.example.service.filter.api;

import org.example.model.UserProfile;

public interface FilterUserProfileService {

    UserProfile findWhereNameLastnameEmail(UserProfile userProfile);
    UserProfile findWhereUserId(Long userId);
}

