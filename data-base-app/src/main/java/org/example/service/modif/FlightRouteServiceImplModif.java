package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.FlightRouteDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.AirPlaneService;
import org.example.service.models.api.UserOrderService;
import org.example.service.modif.api.FlightRouteServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceImplModif implements FlightRouteServiceModif {
    private final FlightRouteDAO flightRouteDAO;
    private final AirPlaneService airPlaneService;
    private final UserOrderService userOrderService;

    @Override
    public FlightRoute create(FlightRoute flightRoute) {
        return flightRouteDAO.save(setForgetValueOnId(flightRoute));
    }

    @Override
    public FlightRoute update(FlightRoute flightRoute) {
        return flightRouteDAO.save(setForgetValueOnId(flightRoute));

    }

    private FlightRoute setForgetValueOnId(FlightRoute flightRoute) {
        if (flightRoute.getRouteStart() != null) {
//            List<Long> airPlaneIdList = flightRoute.getAirPlaneList().stream().map(AirPlane::getId).collect(Collectors.toList());
//            List<AirPlane> airPlaneList = airPlaneService.readAllByIds(airPlaneIdList);
//            flightRoute.setAirPlaneList(airPlaneList);
            List<Long> userOrderIdList = flightRoute.getUserOrderList().stream().map(UserOrder::getId).collect(Collectors.toList());
            List<UserOrder> userOrderFindList = userOrderService.readAllByIds(userOrderIdList);
            flightRoute.setUserOrderList(userOrderFindList);
            return flightRoute;
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }
}
