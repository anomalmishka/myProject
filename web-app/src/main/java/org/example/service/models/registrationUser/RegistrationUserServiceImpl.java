package org.example.service.models.registrationUser;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.exception.ErrorInvalidData;
import org.example.model.Authorities;
import org.example.model.User;
import org.example.service.models.userDetails.CustomUserDetailsService;
import org.example.service.models.authorities.AuthoritiesService;
import org.example.service.models.user.UserService;
import org.example.service.models.userProfile.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegistrationUserServiceImpl implements RegistrationUserService {

    private final UserProfileService userProfileService;
    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthoritiesService authoritiesService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserProfileDTOModif2 create(UserProfileDTOModif2 userProfileDTOModif2, User user) {
        if (!Objects.equals(user.getPassword(), user.getPasswordConfirm())) {
            throw new ErrorInvalidData("Passwords don't match");
        }
        customUserDetailsService.loadUserByUsername(user.getUsername());
        List<Authorities> authorities = user.getAuthorities();
        List<Authorities> authoritiesCreateList = authorities.stream().map(authoritiesService::create).collect(Collectors.toList());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createUser = userService.create(user);
        System.out.println(createUser);
        userProfileDTOModif2.setUserId(createUser.getId());
        userProfileDTOModif2.setIsBlockedProfile(!createUser.getIsEnabled());
        return userProfileService.create(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif2 update(UserProfileDTOModif2 userProfileDTOModif2, User user) {
        userService.update(user);
        return userProfileService.update(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif2 readById(UserProfileDTOModif2 userProfileDTOModif2, User user) {
        return null;
    }
}
