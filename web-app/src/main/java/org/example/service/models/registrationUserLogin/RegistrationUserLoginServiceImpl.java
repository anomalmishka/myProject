package org.example.service.models.registrationUserLogin;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.exception.ErrorInvalidData;
import org.example.model.Authorities;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userLoginDetails.UserLoginDetailsService;
import org.example.service.models.authorities.AuthoritiesService;
import org.example.service.models.userLogin.UserLoginService;
import org.example.service.models.userProfile.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RegistrationUserLoginServiceImpl implements RegistrationUserLoginService {

    private final UserProfileService userProfileService;
    private final UserLoginService userLoginService;
    private final UserLoginDetailsService userLoginDetailsService;
    private final UserLoginCustomService userLoginCustomService;
    private final AuthoritiesService authoritiesService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserProfileDTOModif create(UserProfileDTOModif userProfileDTOModif, UserLogin userLogin) {
        if (!Objects.equals(userLogin.getPassword(), userLogin.getPasswordConfirm())) {
            throw new ErrorInvalidData("Passwords don't match!");
        }
        UserLogin findUserLogin = userLoginCustomService.findByUsername(userLogin.getUsername());
        if (findUserLogin != null) {
            throw new ErrorInvalidData("User with this name already exists");
        } else {
            List<Authorities> authorities = userLogin.getAuthorities();
            authorities.stream().map(authoritiesService::create).close();
            userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
            UserLogin createUserLogin = userLoginService.create(userLogin);
            userLoginDetailsService.loadUserByUsername(userLogin.getUsername());
            userProfileDTOModif.setUserId(createUserLogin.getId());
            userProfileDTOModif.setIsBlockedProfile(!createUserLogin.getIsEnabled());
            return userProfileService.create(userProfileDTOModif);
        }
    }

    @Override
    public UserProfileDTOModif update(UserProfileDTOModif userProfileDTOModif, UserLogin userLogin) {
        userLoginService.update(userLogin);
        return userProfileService.update(userProfileDTOModif);
    }

    @Override
    public UserProfileDTOModif readById(UserProfileDTOModif userProfileDTOModif, UserLogin userLogin) {
        return null;
    }
}
