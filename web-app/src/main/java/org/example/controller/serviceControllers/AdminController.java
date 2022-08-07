package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserLoginDTO;
import org.example.mapper.userLogin.UserLoginMapper;
import org.example.model.UserLogin;
import org.example.service.models.admin.AdminService;
import org.example.service.models.userLogin.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {
private final UserLoginService userLoginService;
private final UserLoginMapper userLoginMapper;
private final AdminService adminService;

    @GetMapping("/admin/block/user")
    public String readUser(Model model) {
        List<UserLoginDTO> userLoginDTOList = userLoginMapper.toPage(userLoginService.readAll());
        model.addAttribute("userLoginDTOList", userLoginDTOList);
        return "pages/admin/adminBlockUser";
    }

    @GetMapping("/admin/block/user/{id}")
    public String blockUser(Model model,
                              @PathVariable("id") Long id) {
        UserLogin userLogin = adminService.isAccountNonLockedChange(id);
        List<UserLoginDTO> userLoginDTOList = userLoginMapper.toPage(userLoginService.readAll());
        model.addAttribute("userLoginDTOList", userLoginDTOList);
        return "pages/admin/adminBlockUser";
    }
}

