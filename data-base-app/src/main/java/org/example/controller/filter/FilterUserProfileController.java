package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.mapper.models.modif.UserProfileMapperModif;
import org.example.service.filter.api.FilterUserProfileService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/user/profile")
public class FilterUserProfileController {
    private final FilterUserProfileService filterUserProfileService;
    private final UserProfileMapperModif userProfileMapperModif;

    @GetMapping(path = "where/user/{userId}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOModif findWhereName(@PathVariable("userId") Long userId) {
        return userProfileMapperModif.toDTO(filterUserProfileService.findWhereUserId(userId));
    }
}

