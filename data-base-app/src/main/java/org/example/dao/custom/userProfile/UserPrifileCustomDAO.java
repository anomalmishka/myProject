package org.example.dao.custom.userProfile;

import org.example.model.UserProfile;

public interface UserPrifileCustomDAO {
    UserProfile findWhereUserId(Long userId);
}
