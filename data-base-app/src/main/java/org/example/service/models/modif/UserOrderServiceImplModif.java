package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.FlightRoute;
import org.example.model.entity.Status;
import org.example.model.entity.UserOrder;
import org.example.service.models.api.FlightRouteService;
import org.example.service.models.api.StatusService;
import org.example.service.models.api.UserOrderService;
import org.example.service.models.modif.api.UserOrderServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserOrderServiceImplModif implements UserOrderServiceModif {
    private final UserOrderService userOrderService;
    private final StatusService statusService;
    private final FlightRouteService flightRouteService;

    @Override
    public UserOrder create(UserOrder userOrder) {
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
        return userOrderService.update(setForgetValueOnId(userOrder));
    }

    private UserOrder setForgetValueOnId(UserOrder userOrder) {
        if (userOrder.getId() != null) {
            Long flightRouteId = userOrder.getFlightRoute().getId();
            FlightRoute flightRoute = flightRouteService.readById(flightRouteId);
            userOrder.setFlightRoute(flightRoute);
            Long statusId = userOrder.getStatus().getId();
            Status status = statusService.readById(statusId);
            userOrder.setStatus(status);
            return userOrder;
        } else {
            throw new ErrorInvalidData("Id must not be null");
        }
    }
}
