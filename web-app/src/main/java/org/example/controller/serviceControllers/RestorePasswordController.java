package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.mapper.user.UserMapper;
import org.example.model.User;
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
    private final UserMapper userMapper;

    @GetMapping("/restore/password")
    public String restorePassword() {
        return "pages/restorePassword/restorePassword";
    }

    @PostMapping("/restore/password")
    public String restorePassword(Model model,
                                  @ModelAttribute UserProfileDTOModif2 userProfileDTOModif2, @ModelAttribute UserDTO userDTO) {
        System.out.println(userProfileDTOModif2);
        System.out.println(userDTO);
        User user = restorePasswordService.restorePassword(userProfileDTOModif2, userMapper.toModel(userDTO));
        model.addAttribute("user", user);
        String redirectUrl = "http://localhost:8001/web-app/login";
        return "redirect:" + redirectUrl;
    }
}
