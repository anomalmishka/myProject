package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserLoginDTO;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.mapper.userLogin.UserLoginMapper;
import org.example.model.UserLogin;
import org.example.service.models.restorePassword.RestorePasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RestorePasswordController {
    private final RestorePasswordService restorePasswordService;
    private final UserLoginMapper userLoginMapper;

    @GetMapping("/restore/password")
    public String restorePassword() {
        return "pages/restorePassword/restorePassword";
    }

    @PostMapping("/restore/password")
    public String restorePassword(Model model,
                                  @ModelAttribute UserProfileDTOModif userProfileDTOModif, @ModelAttribute UserLoginDTO userLoginDTO) {
        UserLogin userLogin = restorePasswordService.restorePassword(userProfileDTOModif, userLoginMapper.toModel(userLoginDTO));
        model.addAttribute("user", userLogin);
        String redirectUrl = "http://localhost:8001/web-app/login";
        return "redirect:" + redirectUrl;
    }
}
