package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.IdListDTO;
import org.example.dto.OrderDataPage;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.dto.page.*;
import org.example.mapper.page.OrderDataMapperPage;
import org.example.mapper.page.PassengerProfileMapperPage;
import org.example.mapper.page.SeatMapperPage;
import org.example.mapper.page.UserOrderMapperPage;
import org.example.service.models.passengerProfileCustom.PassengerProfileCustomService;
import org.example.service.models.userOrderCustom.UserOrderCustomService;
import org.example.service.models.passengerProfile.PassengerProfileService;
import org.example.service.models.seat.SeatService;
import org.example.service.models.userProfileCustom.UserProfileCustomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final UserOrderCustomService userOrderCustomService;
    private final OrderDataMapperPage orderDataMapperPage;
    private final UserOrderMapperPage userOrderMapperPage;
    private final UserProfileCustomService userProfileCustomService;
    private final SeatService seatService;
    private final SeatMapperPage seatMapperPage;
    private final PassengerProfileService passengerProfileService;
    private final PassengerProfileCustomService passengerProfileCustomService;
    private final PassengerProfileMapperPage passengerProfileMapperPage;

    @PostMapping("/order/ready")
    public String readyOrder(Model model,
                             @ModelAttribute OrderDataPage orderDataPage, Principal principal
    ) {
        String username = principal.getName();
        List<PassengerProfilePage> passengerProfilePageList =
                passengerProfileMapperPage.toPage(
                        passengerProfileCustomService.readPassangerProfile(userProfileCustomService.readUserProfile(username)));
        model.addAttribute("passengerProfilePageList", passengerProfilePageList);
        model.addAttribute("orderDataDTO", orderDataPage);
        return "pages/order/readyOrder";
    }

    @PostMapping("/order/create")
    public String createOrder(Model model,
                              @ModelAttribute OrderDataPage orderDataPage) {
        UserOrderPage userOrderPage = userOrderMapperPage.toPage(userOrderCustomService.create(orderDataMapperPage.toDTO(orderDataPage)));
        PassengerProfilePage passengerProfilePage = passengerProfileMapperPage.toPage(passengerProfileService.readById(orderDataMapperPage.toDTO(orderDataPage).getIdPassangerProfile()));
        SeatPage seatPage = seatMapperPage.toPage(seatService.readById(orderDataMapperPage.toDTO(orderDataPage).getIdSeat()));
        model.addAttribute("userOrderPage", userOrderPage);
        model.addAttribute("passengerProfilePage", passengerProfilePage);
        model.addAttribute("seatPage", seatPage);
        return "pages/order/createOrder";
    }

    @GetMapping("/order")
    public String getOrder(Model model,
                            Principal principal) {
        List<PassengerProfilePage> passengerProfilePageList =
                passengerProfileMapperPage.toPage(
                        passengerProfileCustomService.getPassanger(principal));
        System.out.println(passengerProfilePageList);
        model.addAttribute("passengerProfilePageList", passengerProfilePageList);
        return "pages/order/getOrder";
    }

    @GetMapping("/order/cancel/{id}")
    public String cancelOrder(Model model,
                              @PathVariable("id") Long idOrder) {
        UserOrderPage userOrderPage = userOrderMapperPage.toPage(userOrderCustomService.cancelOrder(idOrder));
        StatusPage statusPage = userOrderPage.getStatus();
        FlightRoutePage flightRoute = userOrderPage.getFlightRoute();
        model.addAttribute("userOrderPage", userOrderPage);
        model.addAttribute("statusPage", statusPage);
        model.addAttribute("flightRoute", flightRoute);
        return "pages/order/getOrder";
    }
}
