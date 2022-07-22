package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.UserOrderDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.FlightRoute;
import org.example.model.entity.PassengerProfile;
import org.example.model.entity.Status;
import org.example.model.entity.UserOrder;
import org.example.service.api.FlightRouteService;
import org.example.service.api.PassengerProfileService;
import org.example.service.api.StatusService;
import org.example.service.models.modif.api.UserOrderServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserOrderServiceImplModif implements UserOrderServiceModif {
    private final UserOrderDAO userOrderDAO;
    private final FlightRouteService flightRouteService;
    private final PassengerProfileService passengerProfileService;
    private final StatusService statusService;

    @Override
    public UserOrder create(UserOrder userOrder) {
        return userOrderDAO.save(setForgetValueOnId(userOrder));
    }

    @Override
    public UserOrder update(UserOrder userOrder) {
        if (userOrder.getId() != null) {
            return userOrderDAO.save(setForgetValueOnId(userOrder));
        } else {
            throw new ErrorInvalidData("Id must not be null");
        }
    }

    private UserOrder setForgetValueOnId(UserOrder userOrder) {
        Long flightRouteID = userOrder.getFlightRoute().getId();
        FlightRoute flightRoute = flightRouteService.readById(flightRouteID);
        userOrder.setFlightRoute(flightRoute);
        Long passangerProfileId = userOrder.getPassengerProfile().getId();
        PassengerProfile passengerProfile = passengerProfileService.readById(passangerProfileId);
        userOrder.setPassengerProfile(passengerProfile);
        Long statusId = userOrder.getStatus().getId();
        Status status = statusService.readById(statusId);
        userOrder.setStatus(status);
        return userOrder;
    }
}
