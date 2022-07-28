package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.FilterDTO;
import org.example.dto.page.FlightRoutePage;
import org.example.dto.page.filter.FilterPage;
import org.example.mapper.FilterMapper;
import org.example.mapper.page.FilterMapperPage;
import org.example.mapper.page.FlightRouteMapperPage;
import org.example.service.filter.flightRoute.FlightRouteChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final FlightRouteChoiceService flightRouteChoiceService;
    private final FlightRouteMapperPage flightRouteMapperPage;
    private final FilterMapperPage filterMapperPage;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String getFindRoutePage(Model model,
                                   @ModelAttribute FilterPage filterPage) {
        System.out.println(filterPage);
        List<FlightRoutePage> flightRoutePageList =
                flightRouteMapperPage.toPageDTO(flightRouteChoiceService
                                .selectFilter(filterMapperPage
                                        .toModel(filterPage)));
        System.out.println(flightRoutePageList);
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        return "home";
    }
}
