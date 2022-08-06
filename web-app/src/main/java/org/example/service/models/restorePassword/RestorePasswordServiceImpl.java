package org.example.service.models.restorePassword;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.exception.ErrorInvalidData;
import org.example.model.UserLogin;
import org.example.service.models.userLogin.UserLoginService;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfileCustom.UserProfilePageService;
import org.example.service.models.userProfilePage.UserProfileServiceCustom;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RestorePasswordServiceImpl implements RestorePasswordService {

    private final UserProfileServiceCustom userProfileServiceCustom;
    private final UserLoginService userLoginService;
    private final UserLoginCustomService userLoginCustomService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserLogin restorePassword(UserProfileDTOModif userProfileDTOModif2, UserLogin userLogin) {
        if (!Objects.equals(userLogin.getPassword(), userLogin.getPasswordConfirm())) {
            throw new ErrorInvalidData("Passwords don't match");
        }
        UserLogin findUserLogin = userLoginCustomService.findByUsername(userLogin.getUsername());
        if(findUserLogin == null){
            throw new ErrorInvalidData("User with this login not exists");
        }else {
            UserProfileDTOModif userProfileWhereNameLastnameEmail = userProfileServiceCustom.findWhereNameLastnameEmail(userProfileDTOModif2);
            findUserLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
            return userLoginService.update(findUserLogin);
        }
    }
}
