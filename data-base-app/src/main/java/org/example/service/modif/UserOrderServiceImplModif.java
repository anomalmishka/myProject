package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.model.FlightRoute;
import org.example.model.PassengerProfile;
import org.example.model.Status;
import org.example.model.UserOrder;
import org.example.service.models.api.FlightRouteService;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.models.api.StatusService;
import org.example.service.models.api.UserOrderService;
import org.example.service.modif.api.UserOrderServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserOrderServiceImplModif implements UserOrderServiceModif {
    private final UserOrderService userOrderService;
    private final StatusService statusService;
    private final FlightRouteService flightRouteService;
    private final PassengerProfileService passengerProfileService;

    @Override
    public UserOrder create(UserOrder userOrder) {
        System.out.println("userOrder " + userOrder);
        Long flightRouteId = userOrder.getFlightRoute().getId();
        FlightRoute flightRoute = flightRouteService.readById(flightRouteId);
        userOrder.setFlightRoute(flightRoute);
        Long statusId = userOrder.getStatus().getId();
        Status status = statusService.readById(statusId);
        userOrder.setStatus(status);
        Long passengerProfileId = userOrder.getPassengerProfile().getId();
        PassengerProfile passengerProfile = passengerProfileService.readById(passengerProfileId);
        userOrder.setPassengerProfile(passengerProfile);
        return userOrderService.create(userOrder);
    }

    @Override
    public List<UserOrder> readAll() {
        return userOrderService.readAll();
    }

    @Override
    public UserOrder readById(Long id) {
        return userOrderService.readById(id);
    }

    @Override
    public List<UserOrder> readAllByIds(List<Long> ids) {
        return userOrderService.readAllByIds(ids);
    }

    @Override
    public UserOrder deleteById(Long id) {
        return userOrderService.deleteById(id);
    }

    @Override
    public List<UserOrder> deleteAllByIds(List<Long> ids) {
        return userOrderService.deleteAllByIds(ids);
    }

    @Override
    public UserOrder update(UserOrder userOrder) {
        Long userOrderId = userOrder.getId();
        UserOrder userOrderById = userOrderService.readById(userOrderId);
//        Long statusId = userOrder.getStatus().getId();
//        Status statusById = statusService.readById(statusId);
        userOrderById.setStatus(userOrder.getStatus());
        return userOrderService.update(userOrderById);
    }
}
