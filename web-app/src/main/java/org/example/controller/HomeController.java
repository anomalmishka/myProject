package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.FilterDTO;
import org.example.dto.page.FlightRoutePage;
import org.example.mapper.FilterMapper;
import org.example.mapper.model.modif.FlightRouteMapperModif;
import org.example.mapper.page.FlightRouteMapperPage;
import org.example.service.filter.flightRoute.FlightRouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final FlightRouteService flightRouteService;
    private final FlightRouteMapperModif flightRouteMapperModif;
    private final FlightRouteMapperPage flightRouteMapperPage;
    private final FilterMapper filterMapper;
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @PostMapping("/")
    public String getFindRoutePage(Model model,
                                   @ModelAttribute FilterDTO filterDTO) {
        System.out.println(filterDTO);
        List<FlightRoutePage> flightRoutePageList =
                flightRouteMapperPage.toPageDTO(flightRouteMapperModif
                        .toDTO(flightRouteService
                                .findRoute(filterMapper
                                        .toModel(filterDTO))));
        System.out.println(flightRoutePageList);
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        return "home";
    }
}
