package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.UserProfileDTO;
import org.example.mapper.models.UserProfileMapper;
import org.example.service.filter.api.FilterUserProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/user/profile")
public class FilterUserProfileController {
    private final FilterUserProfileService filterUserProfileService;
    private final UserProfileMapper userProfileMapper;

    @PostMapping(path = "where/user", produces = "application/json", consumes = "application/json")
    public UserProfileDTO findWhereName(@RequestBody UserProfileDTO userProfileDTO) {
        System.out.println(userProfileDTO);
        return userProfileMapper.toDTO(filterUserProfileService.findWhereNameLastnameEmail(userProfileMapper.toModel(userProfileDTO)));
    }
}

