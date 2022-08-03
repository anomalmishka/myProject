package org.example.service.models.registrationLogin;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.exception.ErrorInvalidData;
import org.example.model.Authorities;
import org.example.model.Login;
import org.example.service.models.loginDetails.CustomLoginDetailsService;
import org.example.service.models.authorities.AuthoritiesService;
import org.example.service.models.login.UserService;
import org.example.service.models.userProfile.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegistrationLoginServiceImpl implements RegistrationLoginService {

    private final UserProfileService userProfileService;
    private final UserService userService;
    private final CustomLoginDetailsService customLoginDetailsService;
    private final AuthoritiesService authoritiesService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserProfileDTOModif2 create(UserProfileDTOModif2 userProfileDTOModif2, Login login) {
        if (!Objects.equals(login.getPassword(), login.getPasswordConfirm())) {
            throw new ErrorInvalidData("Passwords don't match");
        }
        customLoginDetailsService.loadUserByUsername(login.getUsername());
        List<Authorities> authorities = login.getAuthorities();
        List<Authorities> authoritiesCreateList = authorities.stream().map(authoritiesService::create).collect(Collectors.toList());
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        Login createLogin = userService.create(login);
        System.out.println(createLogin);
        userProfileDTOModif2.setUserId(createLogin.getId());
        userProfileDTOModif2.setIsBlockedProfile(!createLogin.getIsEnabled());
        return userProfileService.create(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif2 update(UserProfileDTOModif2 userProfileDTOModif2, Login login) {
        userService.update(login);
        return userProfileService.update(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif2 readById(UserProfileDTOModif2 userProfileDTOModif2, Login login) {
        return null;
    }
}
