package org.example.service.filter.api;

import org.example.model.entity.UserProfile;

public interface FilterUserProfileService {

    UserProfile findWhereNameLastnameEmail(UserProfile userProfile);
}

