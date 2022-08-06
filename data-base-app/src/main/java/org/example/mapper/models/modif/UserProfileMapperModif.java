package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.model.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperModif {
    private final ModelMapper modelMapper;

    public UserProfileDTOModif toDTO(UserProfile userProfile) {
            return modelMapper.map(userProfile, UserProfileDTOModif.class);
    }

    public List<UserProfileDTOModif> toDTO(List<UserProfile> userProfileList) {
        return Optional.ofNullable(userProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserProfile> toModel(List<UserProfileDTOModif> userProfileDTOModifList) {
        return Optional.ofNullable(userProfileDTOModifList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public UserProfile toModel(UserProfileDTOModif userProfileDTOModif) {
        return modelMapper.map(userProfileDTOModif, UserProfile.class);
    }
}
