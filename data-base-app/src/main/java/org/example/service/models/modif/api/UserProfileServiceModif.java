package org.example.service.models.modif.api;
import org.example.model.entity.UserProfile;

public interface UserProfileServiceModif {

    UserProfile create(UserProfile userProfile);

    UserProfile update(UserProfile userProfile);
}

