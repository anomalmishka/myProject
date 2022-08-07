package org.example.service.models.order;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDataDTO;
import org.example.dto.models.FlightRouteDTO;
import org.example.dto.models.PassengerProfileDTO;
import org.example.dto.models.SeatDTO;
import org.example.dto.models.StatusDTO;
import org.example.dto.models.modif.*;
import org.example.model.UserLogin;
import org.example.service.models.seat.SeatService;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userOrder.UserOrderService;
import org.example.service.models.userProfileCustom.UserProfileCustomService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final UserOrderService userOrderService;
    private final SeatService seatService;
    private final UserLoginCustomService userLoginCustomService;
    private final UserProfileCustomService userProfileCustomService;

    @Override
    public UserOrderDTOModif create(OrderDataDTO orderDataDTO) {
        UserOrderDTOtoSave userOrderDTOtoSave = UserOrderDTOtoSave.builder()
                .status(StatusDTO.builder()
                        .id(1L)
                        .build())
                .flightRoute(FlightRouteDTO.builder()
                        .id(orderDataDTO.getIdFlightRoute())
                        .build())
                .passengerProfile(PassengerProfileDTO.builder()
                        .id(orderDataDTO.getIdPassangerProfile())
                        .build())
                .build();
        seatService.update(SeatDTO.builder()
                .id(orderDataDTO.getIdSeat())
                .isOrdered(true)
                .build());
        return userOrderService.create(userOrderDTOtoSave);
    }

    @Override
    public UserProfileDTOModif readUserProfile(String username) {
        UserLogin userLogin = userLoginCustomService.findByUsername(username);
        Long userLoginId = userLogin.getId();
        return userProfileCustomService.findWhereUserId(userLoginId);
    }

    @Override
    public List<PassengerProfileDTOModif> readPassangerProfile(UserProfileDTOModif userProfileDTOModif) {
        return userProfileDTOModif.getPassengerProfileList();
    }
}
