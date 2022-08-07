package org.example.service.models.restorePassword;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.exception.ErrorInvalidData;
import org.example.model.UserLogin;
import org.example.service.models.userLogin.UserLoginService;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
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
    public UserLogin restorePassword(UserProfileDTOModif userProfileDTOModif, UserLogin userLogin) {
        if (!Objects.equals(userLogin.getPassword(), userLogin.getPasswordConfirm())) {
            throw new ErrorInvalidData("Passwords don't match");
        }
        UserLogin findUserLogin = userLoginCustomService.findByUsername(userLogin.getUsername());
        if (findUserLogin == null) {
            throw new ErrorInvalidData("User with this login not exists");
        } else {
            Long loginId = findUserLogin.getId();
            UserProfileDTOModif findUserProfileDTOModif = userProfileServiceCustom.findWhereUserId(loginId);
            String getPofilename = userProfileDTOModif.getProfilename();
            String getLastname = userProfileDTOModif.getLastname();
            String getEmail = userProfileDTOModif.getEmail();
            String findProfilename = findUserProfileDTOModif.getProfilename();
            String findLastname = findUserProfileDTOModif.getLastname();
            String findEmail = findUserProfileDTOModif.getEmail();
            if (getPofilename.equals(findProfilename) && getLastname.equals(findLastname) && getEmail.equals(findEmail))
            {
                findUserLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
                return userLoginService.update(findUserLogin);
            }
            else {
                throw new ErrorInvalidData("Given Name or Lastname or Email not equals");
            }
        }
    }
}
