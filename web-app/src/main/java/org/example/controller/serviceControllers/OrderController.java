package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDataPage;
import org.example.dto.page.PassengerProfilePage;
import org.example.dto.page.SeatPage;
import org.example.dto.page.UserOrderPage;
import org.example.mapper.page.OrderDataMapperPage;
import org.example.mapper.page.PassengerProfileMapperPage;
import org.example.mapper.page.SeatMapperPage;
import org.example.mapper.page.UserOrderMapperPage;
import org.example.service.models.order.OrderService;
import org.example.service.models.passengerProfile.PassengerProfileService;
import org.example.service.models.seat.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final OrderService orderService;
    private final OrderDataMapperPage orderDataMapperPage;
    private final UserOrderMapperPage userOrderMapperPage;
    private final SeatService seatService;
    private final SeatMapperPage seatMapperPage;
    private final PassengerProfileService passengerProfileService;
    private final PassengerProfileMapperPage passengerProfileMapperPage;

    @PostMapping("/order/ready")
    public String readyOrder(Model model,
                             @ModelAttribute OrderDataPage orderDataPage, Principal principal
    ) {
        String username = principal.getName();
        List<PassengerProfilePage> passengerProfilePageList =
                passengerProfileMapperPage.toPage(
                        orderService.readPassangerProfile(orderService.readUserProfile(username)));
        model.addAttribute("passengerProfilePageList", passengerProfilePageList);
        model.addAttribute("orderDataDTO", orderDataPage);
        return "pages/order/readyOrder";
    }

    @PostMapping("/order/create")
    public String createOrder(Model model,
                              @ModelAttribute OrderDataPage orderDataPage) {
        UserOrderPage userOrderPage = userOrderMapperPage.toPage(orderService.create(orderDataMapperPage.toDTO(orderDataPage)));
        PassengerProfilePage passengerProfilePage = passengerProfileMapperPage.toPage(passengerProfileService.readById(orderDataMapperPage.toDTO(orderDataPage).getIdPassangerProfile()));
        SeatPage seatPage = seatMapperPage.toPage(seatService.readById(orderDataMapperPage.toDTO(orderDataPage).getIdSeat()));
        model.addAttribute("userOrderPage", userOrderPage);
        model.addAttribute("passengerProfilePage", passengerProfilePage);
        model.addAttribute("seatPage", seatPage);
        return "pages/order/createOrder";
    }
}
