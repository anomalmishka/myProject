package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterAirPlaneDTO;
import org.example.mapper.BuisnessMapper;
import org.example.mapper.FilterMapper;
import org.example.model.filter.BuisnessObj;
import org.example.model.filter.BuisnessObjList;
import org.example.service.interfaces.WebAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class FilterAirPlaneController {

    private final WebAppService webAppService;
    private final BuisnessMapper buisnessMapper;
    private final FilterMapper filterMapper;

    @GetMapping("find/route")
    public String getFindRoutePage() {
        return "pages/findRoute";
    }

    @PostMapping("find/route")
    public String FindRoute(Model model,
                             @ModelAttribute FilterAirPlaneDTO filterAirPlaneDTO) {
        List<BuisnessObjList> buisnessObjListFind = buisnessMapper.toModel(webAppService.findRoute(filterMapper.toModel(filterAirPlaneDTO)));
        model.addAttribute("buisnessObjListFind", buisnessObjListFind);
        return "pages/findRoute";
    }

}


