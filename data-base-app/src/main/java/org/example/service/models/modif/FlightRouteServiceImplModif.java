package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.FlightRouteDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.FlightRoute;
import org.example.model.entity.UserOrder;
import org.example.service.api.UserOrderService;
import org.example.service.models.modif.api.FlightRouteServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FlightRouteServiceImplModif implements FlightRouteServiceModif {
    private final FlightRouteDAO flightRouteDAO;
    private final UserOrderService userOrderService;

    @Override
    public FlightRoute update(FlightRoute flightRoute) {
        if (flightRoute.getRouteStart() != null) {
            List<UserOrder> userOrderList = flightRoute.getUserOrderList();
            List<Long> userOrderIdList = userOrderList.stream().map(UserOrder::getId).collect(Collectors.toList());
            List<UserOrder> userOrderFindList = userOrderService.readAllByIds(userOrderIdList);
            flightRoute.setUserOrderList(userOrderFindList);
            return flightRouteDAO.save(flightRoute);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }
}
