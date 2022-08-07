package org.example.controller.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.IdListDTO;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.page.AirCompanyPage;
import org.example.mapper.page.AirCompanyMapperPage;
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
    private final AirCompanyMapperPage airCompanyMapperPage;

    @GetMapping("main")
    public String mainPage() {
        return "pages/models/airCompany/main";
    }

    @GetMapping("read/all")
    public String readAll(Model model) {
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toPage(airCompanyService.readAll());
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controller/readAll";
    }

    @GetMapping("read/{id}")
    public String readById(Model model,
                           @PathVariable("id") Long id) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toPage(airCompanyService.readById(id));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/readById";
    }

    @GetMapping("read/list/{ids}")
    public String readAllById(Model model,
                              @PathVariable("ids") List<Long> ids) {
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toPage(airCompanyService.readAllByIds(ids));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controller/readAllId";
    }

    @GetMapping("create")
    public String createGet(Model model,
                            @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toPage(airCompanyDTO);
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/create";
    }

    @PostMapping("create")
    public String createPost(Model model,
                             @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toPage(airCompanyService.create(airCompanyDTO));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/create";
    }

    @GetMapping("update")
    public String updateGet(Model model,
                            @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toPage(airCompanyDTO);
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/update";
    }

    @PostMapping("update")
    public String updatePost(Model model,
                             @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toPage(airCompanyService.update(airCompanyDTO));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/update";
    }

    @GetMapping("delete/{id}")
    public String deleteById(Model model,
                             @PathVariable("id") Long id) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toPage(airCompanyService.deleteById(id));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controller/deleteById";
    }

    @GetMapping("delete/all/{ids}")
    public String deleteAllById(Model model,
                                @ModelAttribute IdListDTO ids) {
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toPage(airCompanyService.deleteAllByIds(ids.getId()));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controller/deleteAllById";
    }
}


