package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.IdListDTO;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.example.dto.page.modelPage.FlightRoutePage;
import org.example.mapper.page.FlightRouteMapperPage;
import org.example.service.models.flightRoute.FlightRouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "models/flight/route")
public class FlightRouteController {

    private final FlightRouteService flightRouteService;
    private final FlightRouteMapperPage flightRouteMapperPage;

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
                            @ModelAttribute FlightRouteDTOModif2 flightRouteDTOModif2) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteDTOModif2);
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/create";
    }

    @PostMapping("create")
    public String createPost(Model model,
                             @ModelAttribute FlightRouteDTOModif2 flightRouteDTOModif2) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteService.create(flightRouteDTOModif2));
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/create";
    }

    @GetMapping("update")
    public String updateGet(Model model,
                            @ModelAttribute FlightRouteDTOModif2 flightRouteDTOModif2) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteDTOModif2);
        model.addAttribute("flightRoutePage", flightRoutePage);
        return "pages/models/flightRoute/controller/update";
    }

    @PostMapping("update")
    public String updatePost(Model model,
                             @ModelAttribute FlightRouteDTOModif2 flightRouteDTOModif2) {
        FlightRoutePage flightRoutePage = flightRouteMapperPage.toPage(flightRouteService.update(flightRouteDTOModif2));
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
        System.out.println(ids.getId());
        List<FlightRoutePage> flightRoutePageList = flightRouteMapperPage.toPage(flightRouteService.deleteAllByIds(ids.getId()));
        model.addAttribute("flightRoutePageList", flightRoutePageList);
        return "pages/models/flightRoute/controller/deleteAllById";
    }
}


