package org.example.controller.webClient;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserProfileDTOWeb;
import org.example.dto.models.UserProfileDTO;
import org.example.mapper.UserProfileMapperWeb;
import org.example.service.webClient.UserProfileService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "user/profile")
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final UserProfileMapperWeb userProfileMapperWeb;

    @GetMapping("id")
    public Mono<UserProfileDTO> FindRoute(Model model,
                             @ModelAttribute UserProfileDTOWeb userProfileDTOWeb) {

        Mono<UserProfileDTO> userByIdAsync = userProfileService.getUserByIdAsync(userProfileMapperWeb.toModel(userProfileDTOWeb).getId());
//        model.addAttribute("flightRouteDTOModifPageList", flightRouteDTOModifPageList);
        return userByIdAsync;
    }

    @GetMapping("id/2")
    public UserProfileDTO Finduser(Model model,
                                          @ModelAttribute UserProfileDTOWeb userProfileDTOWeb) {

        UserProfileDTO userProfileDTO = userProfileService.getUserByIdSync(userProfileMapperWeb.toModel(userProfileDTOWeb).getId());
//        model.addAttribute("flightRouteDTOModifPageList", flightRouteDTOModifPageList);
        return userProfileDTO;
    }

}


