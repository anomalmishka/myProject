package org.example.mapper;

import org.example.dto.UserProfileDTOWeb;
import org.example.model.UserProfileWeb;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserProfileMapperWeb {

    public List<UserProfileWeb> toModel(List<UserProfileDTOWeb> userProfileDTOWebList) {
        return userProfileDTOWebList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserProfileWeb toModel(UserProfileDTOWeb userProfileDTOWeb) {
        return UserProfileWeb.builder()
                .idUserProfile(userProfileDTOWeb.getIdUserProfile())
                .id(userProfileDTOWeb.getId())
                .build();
    }
}
