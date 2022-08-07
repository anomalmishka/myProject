package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDataPage;
import org.example.dto.page.SeatPage;
import org.example.dto.page.ViewingFlightInformationPage;
import org.example.mapper.page.SeatMapperPage;
import org.example.mapper.page.ViewingFlightInformationMapperPage;
import org.example.service.filter.FindFlightRouteByFilterService;
import org.example.service.models.seat.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ViewingFlightInformationController {
    private final FindFlightRouteByFilterService findFlightRouteByFilterService;
    private final SeatService seatService;
    private final SeatMapperPage seatMapperPage;
    private final ViewingFlightInformationMapperPage viewingFlightInformationMapperPage;

    private Long ID_FLIGHTROUTE;

    @GetMapping("/view/flight/information/{idFlightRoute}")
    public String viewFlightInfo(Model model,
                                 @PathVariable("idFlightRoute") Long idFlightRoute) {

        List<ViewingFlightInformationPage> viewingFlightInformationPageList = viewingFlightInformationMapperPage.toPage(findFlightRouteByFilterService.findById(idFlightRoute));
        model.addAttribute("viewingFlightInformationPageList", viewingFlightInformationPageList);
        ID_FLIGHTROUTE = idFlightRoute;
        model.addAttribute("idFlightRoute", idFlightRoute);
        return "pages/viewingFlightInformation/viewingFlightInformation";
    }

    @GetMapping("/view/flight/information/seat/{idAirPlane}")
    public String viewSeatInfo(Model model,
                               @PathVariable("idAirPlane") Long idAirPlane,
                               @ModelAttribute OrderDataPage orderDataPage
    ) {
        orderDataPage.setIdFlightRoute(String.valueOf(ID_FLIGHTROUTE));
        List<SeatPage> seatPageList = seatMapperPage.toPage(seatService.findSeatWhereAirPlaneId(idAirPlane));
        model.addAttribute("seatPageList", seatPageList);
        model.addAttribute("orderDataDTO", orderDataPage);
        return "pages/viewingFlightInformation/viewingSeatInformation";
    }
}
