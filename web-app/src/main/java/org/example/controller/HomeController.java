package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.dto.page.filterPage.FilterPage;
import org.example.dto.page.modelPage.FlightRoutePage;
import org.example.mapper.page.FlightRouteMapperPage;
import org.example.mapper.filter.FilterMapperPage;
import org.example.service.filter.filterSelect.FilterSelectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class HomeController {
private final FilterSelectService filterSelectService;
private final FilterMapperPage filterMapperPage;
private final FlightRouteMapperPage flightRouteMapperPage;

    @GetMapping("/")
    public String homeGet(Model model,
                          @ModelAttribute UserDTO userDTO) {
        model.addAttribute("userDTO", userDTO);
        return "home";
    }

    @PostMapping("/")
    public String homePost(Model model,
                                   @ModelAttribute FilterPage filterPage) {
        System.out.println(filterPage);
        List<FlightRoutePage> flightRoutePageList = flightRouteMapperPage.toPage(filterSelectService.filterSelect(filterMapperPage.toOBJ(filterPage)));
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        return "home";
    }
}
