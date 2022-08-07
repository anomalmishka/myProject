package org.example.service.models.userOrderCustom;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDataDTO;
import org.example.dto.models.FlightRouteDTO;
import org.example.dto.models.PassengerProfileDTO;
import org.example.dto.models.SeatDTO;
import org.example.dto.models.StatusDTO;
import org.example.dto.models.modif.*;
import org.example.service.models.seat.SeatService;
import org.example.service.models.userOrder.UserOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserOrderCustomServiceImpl implements UserOrderCustomService {
    private final UserOrderService userOrderService;
    private final SeatService seatService;

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
    public List<UserOrderDTOModif> readAll(PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileDTOModif.getUserOrderList();
    }

    @Override
    public UserOrderDTOModif cancelOrder(Long userOrderId) {
        UserOrderDTOModif userOrderDTOModif = userOrderService.readById(userOrderId);
        Long statusId = userOrderDTOModif.getStatus().getId();
        if (statusId == 1) {
            userOrderDTOModif.setStatus(StatusDTO.builder()
                    .id(3L)
                    .build());
        }else {
            userOrderDTOModif.setStatus(StatusDTO.builder()
                    .id(1L)
                    .build());
        }
        return userOrderService.update(userOrderDTOModif);
    }
}
