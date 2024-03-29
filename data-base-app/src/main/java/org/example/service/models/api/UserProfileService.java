package org.example.service.models.api;
import org.example.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile create(UserProfile userProfile);

    List<UserProfile> readAll();

    UserProfile readById(Long id);

    List<UserProfile> readAllByIds(List<Long> ids);

    UserProfile deleteById(Long id);

    List<UserProfile> deleteAllByIds(List<Long> ids);

    UserProfile update(UserProfile userProfile);
}

