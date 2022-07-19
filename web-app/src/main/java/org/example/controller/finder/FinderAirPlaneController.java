package org.example.controller.finder;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.mapper.AirPlaneMapper;
import org.example.mapper.FilterMapper;
import org.example.model.filter.AirPlaneObjList;
import org.example.service.interfaces.WebAppService;
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
public class FinderAirPlaneController {

    private final WebAppService webAppService;
    private final AirPlaneMapper airPlaneMapper;
    private final FilterMapper filterMapper;

    @GetMapping("route")
    public String getFindRoutePage() {
        return "pages/findRoute";
    }

    @PostMapping("route")
    public String FindRoute(Model model,
                             @ModelAttribute FilterDTO filterDTO) {
        List<AirPlaneObjList> airPlaneObjListFind = airPlaneMapper.toModel(webAppService.findRoute(filterMapper.toModel(filterDTO)));
        model.addAttribute("buisnessObjListFind", airPlaneObjListFind);
        return "pages/findRoute";
    }

}


