package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.dto.page.UserProfilePage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperPage {
    private final ModelMapper modelMapper;


    public UserProfileDTOModif toDTO(UserProfilePage userProfilePage) {
        return modelMapper.map(userProfilePage, UserProfileDTOModif.class);
    }

    public List<UserProfileDTOModif> toDTO(List<UserProfilePage> userProfilePageList) {
        return Optional.ofNullable(userProfilePageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserProfilePage> toPage(List<UserProfileDTOModif> userProfileDTOModifList) {
        return Optional.ofNullable(userProfileDTOModifList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public UserProfilePage toPage(UserProfileDTOModif userProfileDTOModif) {
        return modelMapper.map(userProfileDTOModif, UserProfilePage.class);
    }
}
