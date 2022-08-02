package org.example.service.models.restorePassword;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.UserProfileDTO;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.exception.ErrorInvalidData;
import org.example.model.User;
import org.example.service.models.user.UserService;
import org.example.service.models.userProfile.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RestorePasswordServiceImpl implements RestorePasswordService {

    private final UserProfileService userProfileService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User restorePassword(UserProfileDTOModif2 userProfileDTOModif2, User user) {
        if (!Objects.equals(user.getPassword(), user.getPasswordConfirm())) {
            throw new ErrorInvalidData("Passwords don't match");
        }
        UserProfileDTOModif2 userProfileWhereNameLastnameEmail = userProfileService.findWhereNameLastnameEmail(userProfileDTOModif2);
        Long userId = userProfileWhereNameLastnameEmail.getUserId();
        User findUser = userService.readById(userId);
        findUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.update(findUser);
    }
}
