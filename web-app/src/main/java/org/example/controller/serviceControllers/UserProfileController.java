package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.page.PassengerProfilePage;
import org.example.dto.page.UserProfilePage;
import org.example.mapper.page.PassengerProfileMapperPage;
import org.example.mapper.page.UserProfileMapperPage;
import org.example.service.models.passengerProfile.PassengerProfileService;
import org.example.service.models.passengerProfileCustom.PassengerProfileCustomService;
import org.example.service.models.userProfilePage.UserProfilePageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserProfileController {
    private final UserProfilePageService userProfilePageService;
    private final UserProfileMapperPage userProfileMapperPage;
    private final PassengerProfileMapperPage passengerProfileMapperPage;
    private final PassengerProfileService passengerProfileService;
    private final PassengerProfileCustomService passengerProfileCustomService;

    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal) {
        UserProfilePage userProfilePage = userProfileMapperPage.toPage(userProfilePageService.findWhereName(principal));
        model.addAttribute("userProfilePage", userProfilePage);
        return "pages/userProfile/userProfile";
    }

    @PostMapping("/profile/update")
    public String updateUserProfile(Model model,
                                    @ModelAttribute UserProfilePage userProfilePage, Principal principal
    ) {
        System.out.println("userProfilePage update " + userProfilePage);
        UserProfilePage profilePage = userProfileMapperPage.toPage(userProfilePageService.updateProfile(userProfileMapperPage.toDTO(userProfilePage), principal));
        model.addAttribute("userProfilePage", userProfilePage);
        return "pages/userProfile/userProfile";
    }

    @GetMapping("/profile/passenger")
    public String getPassengerProfile(Model model, Principal principal) {
        List<PassengerProfilePage> passengerProfilePageList = passengerProfileMapperPage.toPage(passengerProfileCustomService.getPassanger(principal));
        model.addAttribute("passengerProfilePageList", passengerProfilePageList);
        return "pages/userProfile/passengerProfile";
    }

    @PostMapping("/profile/passenger")
    public String createPassengerProfile(Model model,
                                         @ModelAttribute PassengerProfilePage createPassengerProfilePage, Principal principal) {
        List<PassengerProfilePage> passengerProfilePageList =
                passengerProfileMapperPage.toPage(
                        passengerProfileCustomService.create(
                                passengerProfileMapperPage.toDTO(createPassengerProfilePage), principal));
        model.addAttribute("passengerProfilePageList", passengerProfilePageList);
        return "pages/userProfile/passengerProfile";
    }
}
