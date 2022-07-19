package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.filter.BuisnessObj;
import org.example.model.filter.FilterObj;
import org.example.mapper.BuisnessMapper;
import org.example.mapper.FilterMapper;
import org.example.service.interfaces.WebAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PagesController {

    private final WebAppService webAppService;
    private final BuisnessMapper buisnessMapper;
    private final FilterMapper filterMapper;

    @GetMapping("create/user")
    public String getCreateUserPage() {
        return "pages/createUser";
    }

    @PostMapping("create/user")
    public String createUser(Model model,
                             @ModelAttribute BuisnessObj buisnessObj) {
//        BuisnessObjList buisnessObjListCreate = buisnessMapper.toModel(webAppService.createUser(buisnessMapper.toDTO(buisnessObj)));
//        model.addAttribute("buisnessObjListCreate", buisnessObjListCreate);
        return "pages/createUser";
    }

    @GetMapping("update/user/wcd")
    public String getUpdateUserWithCarAndDealerPage() {
        return "pages/updateUserWithCarAndDealer";
    }

    @PostMapping("update/user/wcd")
    public String updateUserWithCarAndDealer(Model model,
                                             @ModelAttribute BuisnessObj buisnessObj) {
//        BuisnessObjList buisnessObjListUpdate = buisnessMapper.toModel(webAppService.updateUserWithCarAndDealer(buisnessMapper.toDTO(buisnessObj)));
//        model.addAttribute("buisnessObjListUpdate", buisnessObjListUpdate);
        return "pages/updateUserWithCarAndDealer";
    }

    @GetMapping("create/aps")
    public String getCreateAutoPartsAndSalesPage() {
        return "pages/createAutoPartsAndSales";
    }

    @PostMapping("create/aps")
    public String createAutoPartsAndSales(Model model,
                                          @ModelAttribute BuisnessObj buisnessObj) {
//        BuisnessObjList buisnessObjListCreate = buisnessMapper.toModel(webAppService.createAutoPartsAndSales(buisnessMapper.toDTO(buisnessObj)));
//        model.addAttribute("buisnessObjListCreate", buisnessObjListCreate);
        return "pages/createAutoPartsAndSales";
    }

    @GetMapping("update/user/all")
    public String getUpdateUserWithAllPage() {
        return "pages/updateUserWithAll";
    }

    @PostMapping("update/user/all")
    public String updateUserWithAll(Model model,
                                    @ModelAttribute BuisnessObj buisnessObj) {
//        BuisnessObjList buisnessObjListUpdate = buisnessMapper.toModel(webAppService.updateUserWithAll(buisnessMapper.toDTO(buisnessObj)));
//        model.addAttribute("buisnessObjListUpdate", buisnessObjListUpdate);
        return "pages/updateUserWithAll";
    }

    @GetMapping("read/user/wcd")
    public String getReadUserWithCarAndDealerPage() {
        return "pages/readUserWithCarAndDealer";
    }

    @PostMapping("read/user/wcd")
    public String readUserWithCarAndDealer(Model model,
                                           @ModelAttribute BuisnessObj buisnessObj) {
//        BuisnessObjList buisnessObjListRead = buisnessMapper.toModel(webAppService.readUserWithCarAndDealer(buisnessMapper.toDTO(buisnessObj)));
//        model.addAttribute("buisnessObjListRead", buisnessObjListRead);
        return "pages/readUserWithCarAndDealer";
    }

    @GetMapping("delete/user/all")
    public String getDeleteUserWithAllPage() {
        return "pages/deleteUserWithAll";
    }

    @PostMapping("delete/user/all")
    public String deleteUserWithAll(Model model,
                                    @ModelAttribute BuisnessObj buisnessObj) {
//        BuisnessObjList buisnessObjListDelete = buisnessMapper.toModel(webAppService.deleteUserWithAll(buisnessMapper.toDTO(buisnessObj)));
//        model.addAttribute("buisnessObjListDelete", buisnessObjListDelete);
        return "pages/deleteUserWithAll";
    }

    @GetMapping("find/name")
    public String getFindUserNameWhereCarBrandPage() {
        return "pages/findUserNameWhereCarBrand";
    }

    @PostMapping("find/name")
    public String findUserNameWhereCarBrand(Model model,
                                            @ModelAttribute FilterObj filterObj) {
//        List<BuisnessObjList> buisnessObjList = buisnessMapper.toModelModif(webAppService.findUserNameWhereCarBrand(filterMapper.toDTO(filterObj)));
//        model.addAttribute("buisnessObjList", buisnessObjList);
        return "pages/findUserNameWhereCarBrand";
    }

    @GetMapping("find/lastname")
    public String getFindUserLastnameWhereDealerSalesmanPage() {
        return "pages/findUserLastnameWhereDealerSalesman";
    }

    @PostMapping("find/lastname")
    public String findUserLastnameWhereDealerSalesman(Model model,
                                                      @ModelAttribute FilterObj filterObj) {
//        List<BuisnessObjList> buisnessObjList = buisnessMapper.toModelModif(webAppService.findUserLastnameWhereDealerSalesman(filterMapper.toDTO(filterObj)));
//        model.addAttribute("buisnessObjList", buisnessObjList);
        return "pages/findUserLastnameWhereDealerSalesman";
    }

    @GetMapping("find/category")
    public String getFindUserCategoryClientWhereAutoPartsBrandNamePage() {
        return "pages/findUserCategoryClientWhereAutoPartsBrandName";
    }

    @PostMapping("find/category")
    public String findUserCategoryClientWhereAutoPartsBrandName(Model model,
                                                                @ModelAttribute FilterObj filterObj) {
//        List<BuisnessObjList> buisnessObjList = buisnessMapper.toModelModif(webAppService.findUserCategoryClientWhereAutoPartsBrandName(filterMapper.toDTO(filterObj)));
//        model.addAttribute("buisnessObjList", buisnessObjList);
        return "pages/findUserCategoryClientWhereAutoPartsBrandName";
    }

    @GetMapping("find/phone")
    public String getFindUserPhoneWhereSalesPage() {
        return "pages/findUserPhoneWhereSales";
    }

    @PostMapping("find/phone")
    public String findUserPhoneWhereSales(Model model,
                                          @ModelAttribute FilterObj filterObj) {
//        List<BuisnessObjList> buisnessObjList = buisnessMapper.toModelModif(webAppService.findUserPhoneWhereSales(filterMapper.toDTO(filterObj)));
//        model.addAttribute("buisnessObjList", buisnessObjList);
        return "pages/findUserPhoneWhereSales";
    }
}


