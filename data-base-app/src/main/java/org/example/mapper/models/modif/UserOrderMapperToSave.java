package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserOrderDTOtoSave;
import org.example.mapper.models.FlightRouteMapper;
import org.example.mapper.models.PassengerProfileMapper;
import org.example.mapper.models.StatusMapper;
import org.example.model.UserOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserOrderMapperToSave {
    private final ModelMapper modelMapper;
    private final FlightRouteMapper flightRouteMapper;
    private final StatusMapper statusMapper;
    private final PassengerProfileMapper passengerProfileMapper;

    public UserOrderDTOtoSave toDTO(UserOrder userOrder) {
        return modelMapper.map(userOrder, UserOrderDTOtoSave.class);
    }

    public List<UserOrderDTOtoSave> toDTO(List<UserOrder> userOrderList) {
        return Optional.ofNullable(userOrderList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserOrder> toModel(List<UserOrderDTOtoSave> userOrderDTOtoSaveList) {
        return Optional.ofNullable(userOrderDTOtoSaveList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    //    public UserOrder toModel(UserOrderDTOtoSave userOrderDTOtoSave) {
//        return UserOrder.builder()
//                .id(userOrderDTOtoSave.getId())
//                .flightRoute(flightRouteMapper.toModel(userOrderDTOtoSave.getFlightRouteDTO()))
//                .status(statusMapper.toModel(userOrderDTOtoSave.getStatusDTO()))
//                .passengerProfile(passengerProfileMapper.toModel(userOrderDTOtoSave.getPassengerProfileDTO()))
//                .build();
//    }
    public UserOrder toModel(UserOrderDTOtoSave userOrderDTOtoSave) {
        return modelMapper.map(userOrderDTOtoSave, UserOrder.class);
    }
}
