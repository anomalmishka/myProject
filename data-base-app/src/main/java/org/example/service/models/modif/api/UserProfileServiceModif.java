package org.example.service.models.modif.api;
import org.example.model.entity.UserProfile;

import java.util.List;

public interface UserProfileServiceModif {

    UserProfile create(UserProfile userProfile);

    List<UserProfile> readAll();

    UserProfile readById(Long id);

    List<UserProfile> readAllByIds(List<Long> ids);

    UserProfile deleteById(Long id);

    List<UserProfile> deleteAllByIds(List<Long> ids);

    UserProfile update(UserProfile userProfile);
}

