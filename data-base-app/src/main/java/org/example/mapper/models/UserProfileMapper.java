package org.example.mapper.models;

import org.example.dto.modelsDTO.UserProfileDTO;
import org.example.model.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserProfileMapper {
    public UserProfileDTO toDTO(UserProfile userProfile) {
        return UserProfileDTO.builder()
                .id(userProfile.getId())
                .name(userProfile.getName())
                .lastname(userProfile.getLastname())
                .phone(userProfile.getPhone())
                .email(userProfile.getEmail())
                .userId(userProfile.getUserId())
                .isBlockedProfile(userProfile.getIsBlockedProfile())
                .build();
    }

    public List<UserProfileDTO> toDTO(List<UserProfile> userProfileList) {
        return userProfileList.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<UserProfile> toModel(List<UserProfileDTO> userProfileDTOList) {
        return userProfileDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public UserProfile toModel(UserProfileDTO userProfileDTO) {
        return UserProfile.builder()
                .id(userProfileDTO.getId())
                .name(userProfileDTO.getName())
                .lastname(userProfileDTO.getLastname())
                .phone(userProfileDTO.getPhone())
                .email(userProfileDTO.getEmail())
                .userId(userProfileDTO.getUserId())
                .isBlockedProfile(userProfileDTO.getIsBlockedProfile())
                .build();
    }
}
