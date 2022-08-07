package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterPage;
import org.example.dto.page.FlightRoutePage;
import org.example.mapper.page.FlightRouteMapperPage;
import org.example.mapper.filter.FilterMapper;
import org.example.service.filter.FindFlightRouteByFilterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final FindFlightRouteByFilterService findFlightRouteByFilterService;
    private final FilterMapper filterMapper;
    private final FlightRouteMapperPage flightRouteMapperPage;

    @GetMapping("/")
    public String homeGet(Model model, Principal principal) {
        String userPrincipalName;
        if (principal != null) {
            userPrincipalName = principal.getName();
        } else {
            userPrincipalName = "None";
        }
        model.addAttribute("userPrincipalName", userPrincipalName);
        return "home";
    }

    @PostMapping("/")
    public String homePost(Model model,
                           @ModelAttribute FilterPage filterPage, Principal principal) {
        String userPrincipalName;
        if (principal != null) {
            userPrincipalName = principal.getName();
        } else {
            userPrincipalName = "None";
        }
        List<FlightRoutePage> flightRoutePageList = flightRouteMapperPage.toPage(findFlightRouteByFilterService.findByCondition(filterMapper.toDTO(filterPage)));
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        model.addAttribute("userPrincipalName", userPrincipalName);
        return "home";
    }
}
