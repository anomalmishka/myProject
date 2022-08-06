package org.example.service.models.order;

import org.example.dto.OrderDataDTO;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;

import java.util.List;


public interface OrderService {
    UserOrderDTOModif create(OrderDataDTO orderDataDTO);

    UserProfileDTOModif readUserProfile(String username);

    List<PassengerProfileDTOModif> readPassangerProfile(UserProfileDTOModif userProfileDTOModif);
}
