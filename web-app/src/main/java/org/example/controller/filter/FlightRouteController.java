package org.example.controller.filter;

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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "find")
public class FlightRouteController {

    private final FlightRouteService flightRouteService;
    private final FlightRouteMapperModif flightRouteMapperModif;
    private final FlightRouteMapperPage flightRouteMapperPage;
    private final FilterMapper filterMapper;

    @GetMapping("route")
    public String getFindRoutePage() {
        return "pages/findRoute";
    }

    @PostMapping("route")
    public String FindRoute(Model model,
                            @ModelAttribute FilterDTO filterDTO) {
        List<FlightRoutePage> flightRoutePageList =
                flightRouteMapperPage.toPageDTO(flightRouteMapperModif
                        .toDTO(flightRouteService
                                .findRoute(filterMapper
                                        .toModel(filterDTO))));
        model.addAttribute("flightRouteDTOModifPageList", flightRoutePageList);
        return "pages/findRoute";
    }

}


