package org.example.controller.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.page.AirCompanyPage;
import org.example.mapper.model.AirCompanyMapper;
import org.example.mapper.model.modif.AirCompanyMapperModif;
import org.example.mapper.page.AirCompanyMapperPage;
import org.example.service.models.airCompany.AirCompanyService;
import org.example.service.models.modif.airCompany.AirCompanyServiceModif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "models/modif/air/company")
public class AirCompanyControllerModif {

    private final AirCompanyServiceModif airCompanyServiceModif;
    private final AirCompanyService airCompanyService;
    private final AirCompanyMapperModif airCompanyMapperModif;
    private final AirCompanyMapper airCompanyMapper;
    private final AirCompanyMapperPage airCompanyMapperPage;

    @GetMapping("main")
    public String mainPage() {
        return "pages/models/airCompany/main";
    }

    @GetMapping("read/all")
    public String readAll(Model model) {
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toDTOModif(airCompanyMapperModif
                .toDTO(airCompanyServiceModif.readAll()));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controllerModif/readAll";
    }


    @GetMapping("read/{id}")
    public String readById(Model model, @PathVariable("id") Long id) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTOModif(airCompanyMapperModif
                .toDTO(airCompanyServiceModif.readById(id)));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controllerModif/readById";
    }

    @GetMapping("read/all/{ids}")
    public String readAllById(Model model, @PathVariable("ids") List<Long> ids) {
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toDTOModif(airCompanyMapperModif
                .toDTO(airCompanyServiceModif.readAllByIds(ids)));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controllerModif/readAllId";
    }

    @GetMapping("create")
    public String create() {
        return "pages/models/airCompany/controllerModif/create";
    }

    @PostMapping("create")
    public String create(Model model,
                         @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTOModif(airCompanyMapperModif
                .toDTO(airCompanyServiceModif.create(airCompanyMapper.toModel(airCompanyDTO))));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controllerModif/create";
    }

    @GetMapping("update")
    public String update() {
        return "pages/models/airCompany/controllerModif/update";
    }

    @PostMapping("update")
    public String update(Model model,
                         @ModelAttribute AirCompanyDTO airCompanyDTO) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTOModif(airCompanyMapperModif
                .toDTO(airCompanyServiceModif.update(airCompanyMapper.toModel(airCompanyDTO))));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controllerModif/update";
    }

    @GetMapping("delete/{id}")
    public String deleteById(Model model, @PathVariable("id") Long id) {
        AirCompanyPage airCompanyPage = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.deleteById(id)));
        model.addAttribute("airCompanyPage", airCompanyPage);
        return "pages/models/airCompany/controllerModif/deleteById";
    }

    @GetMapping("delete/all/{id}")
    public String deleteAllById(Model model, @PathVariable("ids") List<Long> ids) {
        List<AirCompanyPage> airCompanyPageList = airCompanyMapperPage.toDTO(airCompanyMapper
                .toDTO(airCompanyService.deleteAllByIds(ids)));
        model.addAttribute("airCompanyPageList", airCompanyPageList);
        return "pages/models/airCompany/controllerModif/deleteAllById";
    }
}


