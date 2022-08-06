package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.userProfile.UserPrifileCustomDAO;
import org.example.model.UserProfile;
import org.example.service.filter.api.FilterUserProfileService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FilterUserProfileServiceImpl implements FilterUserProfileService {
    private final UserPrifileCustomDAO userPrifileCustomDAO;

    @Override
    public UserProfile findWhereNameLastnameEmail(UserProfile userProfile) {
        return userPrifileCustomDAO.findWhereNameLastnameEmail(userProfile);
    }

    @Override
    public UserProfile findWhereUserId(Long userId) {
        return userPrifileCustomDAO.findWhereUserId(userId);
    }
}
