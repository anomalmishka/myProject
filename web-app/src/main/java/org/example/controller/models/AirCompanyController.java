package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.GetIdDTO;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.page.AirCompanyPage;
import org.example.mapper.model.AirCompanyMapper;
import org.example.mapper.page.AirCompanyMapperPage;
import org.example.mapper.GetIdMapper;
import org.example.service.models.airCompany.AirCompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "models/air/company")
public class AirCompanyController {

    private final AirCompanyService airCompanyService;
    private final AirCompanyMapper airCompanyMapper;
    private final AirCompanyMapperPage airCompanyMapperPage;
    private final GetIdMapper getIdMapper;

    @GetMapping("main")
    public String mainPage() {
        return "pages/models/airCompany/main";
    }

    @GetMapping("read/all")
    public String readAllPage(Model model) {
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.readAll()));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controller/readAll";
    }

    @GetMapping("read/id")
    public String readSingleId() {
        return "pages/models/airCompany/controller/readById";
    }

    @PostMapping("read/id")
    public String readSingleId(Model model,
                               @ModelAttribute GetIdDTO getIdDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.readById(getIdMapper.toModel(getIdDTO).getId())));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/readById";
    }

    @GetMapping("read/all/id")
    public String readAllById() {
        return "pages/models/airCompany/controller/readAllId";
    }

    @PostMapping("read/all/id")
    public String readAllById(Model model,
                              @ModelAttribute GetIdDTO getIdDTO) {
        getIdDTO.setIdlist(List.of(getIdDTO.getId()));
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.readAllByIds(getIdMapper.toModel(getIdDTO).getIdlist())));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controller/readAllId";
    }

    @GetMapping("create")
    public String create() {
        return "pages/models/airCompany/controller/create";
    }

    @PostMapping("create")
    public String create(Model model,
                         @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.create(airCompanyMapper.toModel(airCompanyDTO))));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/create";
    }

    @GetMapping("update")
    public String update() {
        return "pages/models/airCompany/controller/update";
    }

    @PostMapping("update")
    public String update(Model model,
                         @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.update(airCompanyMapper.toModel(airCompanyDTO))));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/update";
    }

    @GetMapping("delete/id")
    public String deleteById() {
        return "pages/models/airCompany/controller/deleteById";
    }

    @PostMapping("delete/id")
    public String deleteById(Model model,
                             @ModelAttribute GetIdDTO getIdDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.deleteById(getIdMapper.toModel(getIdDTO).getId())));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/deleteById";
    }

    @GetMapping("delete/all/id")
    public String deleteAllById() {
        return "pages/models/airCompany/controller/deleteAllById";
    }

    @PostMapping("delete/all/id")
    public String deleteAllById(Model model,
                                @ModelAttribute GetIdDTO getIdDTO) {
        getIdDTO.setIdlist(List.of(getIdDTO.getId()));
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.deleteAllByIds(getIdMapper.toModel(getIdDTO).getIdlist())));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controller/deleteAllById";
    }
}


