package org.example.service.filter.api;

import org.example.model.UserProfile;

public interface FilterUserProfileService {

    UserProfile findWhereUserId(Long userId);
}

