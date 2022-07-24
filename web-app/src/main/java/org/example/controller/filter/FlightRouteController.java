package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.dto.models.page.FlightRouteDTOModifPage;
import org.example.mapper.filter.FilterMapper;
import org.example.mapper.modif.FlightRouteMapperModif;
import org.example.mapper.page.FlightRouteMapperPage;
import org.example.service.filter.flightRoute.FilterFlightRouteService;
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

    private final FilterFlightRouteService filterFlightRouteService;
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
        List<FlightRouteDTOModifPage> flightRouteDTOModifPageList =
                flightRouteMapperPage.toPageDTO(flightRouteMapperModif.toDTO(filterFlightRouteService.findRoute(filterMapper.toModel(filterDTO))));
        model.addAttribute("flightRouteDTOModifPageList", flightRouteDTOModifPageList);
        return "pages/findRoute";
    }

}


