package org.example.service.models.userOrderCustom;

import org.example.dto.OrderDataDTO;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserOrderDTOModif;

import java.util.List;

public interface UserOrderCustomService {
    UserOrderDTOModif create(OrderDataDTO orderDataDTO);

    List<UserOrderDTOModif> readAll(PassengerProfileDTOModif passengerProfileDTOModif);

    UserOrderDTOModif cancelOrder(Long userOrderId);
}
