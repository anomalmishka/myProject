package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.PassengerProfileDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.UserOrderService;
import org.example.service.models.api.UserProfileService;
import org.example.service.modif.api.PassengerProfileServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PassengerProfileServiceImplModif implements PassengerProfileServiceModif {
    private final PassengerProfileDAO passengerProfileDAO;
    private final UserProfileService userProfileService;
    private final UserOrderService userOrderService;

    @Override
    public PassengerProfile create(PassengerProfile passengerProfile) {
        return passengerProfileDAO.save(setForgetValueOnId(passengerProfile));
    }

    @Override
    public PassengerProfile update(PassengerProfile passengerProfile) {
        return passengerProfileDAO.save(setForgetValueOnId(passengerProfile));
    }

    private PassengerProfile setForgetValueOnId(PassengerProfile passengerProfile) {
        if (passengerProfile.getName() != null) {
            Long userProfileId = passengerProfile.getUserProfile().getId();
            UserProfile userProfile = userProfileService.readById(userProfileId);
            passengerProfile.setUserProfile(userProfile);
            List<Long> userOrderIdList = passengerProfile.getUserOrderList().stream().map(UserOrder::getId).collect(Collectors.toList());
            List<UserOrder> userOrderList = userOrderService.readAllByIds(userOrderIdList);
            passengerProfile.setUserOrderList(userOrderList);
            return passengerProfile;
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
