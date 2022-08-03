package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.LoginDTO;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.dto.page.modelPage.UserProfilePage;
import org.example.mapper.page.UserProfileMapperPage;
import org.example.mapper.login.LoginMapper;
import org.example.service.models.registrationLogin.RegistrationLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RegistrationController {
    private final RegistrationLoginService registrationLoginService;
    private final UserProfileMapperPage userProfileMapperPage;
    private final LoginMapper loginMapper;

    @GetMapping("/registration")
    public String registration() {
        return "pages/registration/registration";
    }

    @PostMapping("/registration/create")
    public String registration(Model model,
                               @ModelAttribute UserProfileDTOModif2 userProfileDTOModif2, @ModelAttribute LoginDTO loginDTO) {
        UserProfilePage userProfilePage = userProfileMapperPage.toPage(registrationLoginService.create(
                userProfileDTOModif2,
                loginMapper.toModel(loginDTO)
        ));
        model.addAttribute("userProfilePage", userProfilePage);
        model.addAttribute("userDTO", loginDTO);
        String redirectUrl = "http://localhost:8001/web-app/login";
        return "redirect:" + redirectUrl;
    }
}
