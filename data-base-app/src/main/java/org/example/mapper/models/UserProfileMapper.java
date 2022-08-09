package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.UserProfileDTO;
import org.example.model.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapper {

    private final ModelMapper modelMapper;

    public UserProfileDTO toDTO(UserProfile userProfile) {
        System.out.println(userProfile);
        return modelMapper.map(userProfile, UserProfileDTO.class);
    }

    public List<UserProfileDTO> toDTO(List<UserProfile> userProfileList) {
        return Optional.ofNullable(userProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserProfile> toModel(List<UserProfileDTO> userProfileDTOList) {
        return Optional.ofNullable(userProfileDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public UserProfile toModel(UserProfileDTO userProfileDTO) {
        return modelMapper.map(userProfileDTO, UserProfile.class);
    }
}
