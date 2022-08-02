package org.example.dao.custom.userProfile;

import org.example.model.entity.UserProfile;

public interface UserPrifileCustomDAO {
    UserProfile findWhereNameLastnameEmail(UserProfile userProfile);
}
