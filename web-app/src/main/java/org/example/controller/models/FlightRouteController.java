package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.IdListDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.dto.page.AirPlanePage;
import org.example.dto.page.FlightRoutePage;
import org.example.mapper.page.AirPlaneMapperPage;
import org.example.mapper.page.FlightRouteMapperPage;
import org.example.service.models.airPlane.AirPlaneService;
import org.example.service.models.flightRoute.FlightRouteService;
import org.example.service.models.flightRouteCustom.FlightRouteServiceCustom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "models/flight/route")
public class FlightRouteController {

    private final FlightRouteService flightRouteService;
    private final FlightRouteServiceCustom flightRouteServiceCustom;

    private final FlightRouteMapperPage flightRouteMapperPage;
    private final AirPlaneService airPlaneService;
    private final AirPlaneMapperPage airPlaneMapperPage;

    @GetMapping("main")
    public String mainPage() {
        return "pages/models/flightRoute/main";
    }

    @GetMapping("read/all")
    public String readAll(Model model) {
        List<FlightRoutePage> flightRoutePageList = flightRouteMapperPage.toPage(flightRouteService.readAll());
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        return "pages/models/flightRoute/controller/readAll";
    }

    @GetMapping("read/{id}")
    public String readById(Model model,
                           @PathVariable("id") Long id) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteService.readById(id));
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/readById";
    }

    @GetMapping("read/list/{ids}")
    public String readAllById(Model model,
                              @PathVariable("ids") List<Long> ids) {
        List<FlightRoutePage> flightRoutePageList = flightRouteMapperPage.toPage(flightRouteService.readAllByIds(ids));
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        return "pages/models/flightRoute/controller/readAllId";
    }

    @GetMapping("create")
    public String createGet(Model model,
                            @ModelAttribute FlightRoutePage flightRoutePage) {
        List<AirPlanePage> airPlanePageList = airPlaneMapperPage.toPage(airPlaneService.readAll());
        model.addAttribute("airPlanePageList", airPlanePageList);
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/create";
    }

    @PostMapping("create")
    public String createPost(Model model,
                             @ModelAttribute FlightRoutePage flightRoutePage,
                             @ModelAttribute IdListDTO id) {
        Long idAirPlane = id.getId().stream().findFirst().orElse(null);
        List<AirPlanePage> airPlanePageList = airPlaneMapperPage.toPage(airPlaneService.readAll());
        FlightRoutePage createRoutePage = flightRouteMapperPage.toPage(flightRouteServiceCustom.create(flightRouteMapperPage.toDTO(flightRoutePage), idAirPlane));
        model.addAttribute("flightRoutePage", createRoutePage);
        model.addAttribute("airPlanePageList", airPlanePageList);
        return "pages/models/flightRoute/controller/create";
    }

    @GetMapping("update")
    public String updateGet(Model model,
                            @ModelAttribute FlightRouteDTOModif flightRouteDTOModif) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteDTOModif);
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/update";
    }

    @PostMapping("update")
    public String updatePost(Model model,
                             @ModelAttribute FlightRouteDTOModif flightRouteDTOModif) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteService.update(flightRouteDTOModif));
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/update";
    }

    @GetMapping("delete/{id}")
    public String deleteById(Model model,
                             @PathVariable("id") Long id) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteService.deleteById(id));
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/deleteById";
    }

    @GetMapping("delete/all/{ids}")
    public String deleteAllById(Model model,
                                @ModelAttribute IdListDTO ids) {
        List<FlightRoutePage> flightRoutePageList = flightRouteMapperPage.toPage(flightRouteService.deleteAllByIds(ids.getId()));
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        return "pages/models/flightRoute/controller/deleteAllById";
    }
}


