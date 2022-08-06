package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.UserProfileDTO;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.mapper.models.UserProfileMapper;
import org.example.mapper.models.modif.UserProfileMapperModif;
import org.example.service.filter.api.FilterUserProfileService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/user/profile")
public class FilterUserProfileController {
    private final FilterUserProfileService filterUserProfileService;
    private final UserProfileMapper userProfileMapper;
    private final UserProfileMapperModif userProfileMapperModif;

    @PostMapping(path = "where/user", produces = "application/json", consumes = "application/json")
    public UserProfileDTO findWhereName(@RequestBody UserProfileDTO userProfileDTO) {
        return userProfileMapper.toDTO(filterUserProfileService.findWhereNameLastnameEmail(userProfileMapper.toModel(userProfileDTO)));
    }

    @GetMapping(path = "where/user/{userId}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif findWhereName(@PathVariable("userId") Long userId) {
        return userProfileMapperModif.toDTO(filterUserProfileService.findWhereUserId(userId));
    }
}

