package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.models.api.UserOrderService;
import org.example.service.models.modif.api.PassengerProfileServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PassengerProfileServiceImplModif implements PassengerProfileServiceModif {
    private final PassengerProfileService passengerProfileService;
    private final UserOrderService userOrderService;

    @Override
    public PassengerProfile create(PassengerProfile passengerProfile) {
        return passengerProfileService.create(passengerProfile);
    }

    @Override
    public List<PassengerProfile> readAll() {
        return passengerProfileService.readAll();
    }

    @Override
    public PassengerProfile readById(Long id) {
        return passengerProfileService.readById(id);
    }

    @Override
    public List<PassengerProfile> readAllByIds(List<Long> ids) {
        return passengerProfileService.readAllByIds(ids);
    }

    @Override
    public PassengerProfile deleteById(Long id) {
        return passengerProfileService.deleteById(id);
    }

    @Override
    public List<PassengerProfile> deleteAllByIds(List<Long> ids) {
        return passengerProfileService.deleteAllByIds(ids);
    }

    @Override
    public PassengerProfile update(PassengerProfile passengerProfile) {
        return passengerProfileService.update(setForgetValueOnId(passengerProfile));
    }

    private PassengerProfile setForgetValueOnId(PassengerProfile passengerProfile) {
        System.out.println(passengerProfile);
        if (passengerProfile.getName() != null) {
            List<Long> userOrderIdList = passengerProfile.getUserOrderList().stream().map(UserOrder::getId).collect(Collectors.toList());
            List<UserOrder> userOrderList = userOrderService.readAllByIds(userOrderIdList);
            passengerProfile.setUserOrderList(userOrderList);
            return passengerProfile;
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
