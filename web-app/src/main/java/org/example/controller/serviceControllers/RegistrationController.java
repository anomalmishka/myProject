package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.dto.modelsDTO.UserProfileDTO;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.dto.page.modelPage.UserProfilePage;
import org.example.mapper.page.UserProfileMapperPage;
import org.example.mapper.user.UserMapper;
import org.example.service.models.registrationUser.RegistrationUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RegistrationController {
    private final RegistrationUserService registrationUserService;
    private final UserProfileMapperPage userProfileMapperPage;
    private final UserMapper userMapper;

    @GetMapping("/registration")
    public String registration() {
        return "pages/registration/registration";
    }

    @PostMapping("/registration/create")
    public String registration(Model model,
                               @ModelAttribute UserProfileDTOModif2 userProfileDTOModif2, @ModelAttribute UserDTO userDTO) {
        UserProfilePage userProfilePage = userProfileMapperPage.toPage(registrationUserService.create(
                userProfileDTOModif2,
                userMapper.toModel(userDTO)
        ));
        model.addAttribute("userProfilePage", userProfilePage);
        model.addAttribute("userDTO", userDTO);
        String redirectUrl = "http://localhost:8001/web-app/login";
        return "redirect:" + redirectUrl;
    }
}
