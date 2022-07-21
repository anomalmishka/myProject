package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.AirPlaneDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;
import org.example.model.entity.Seat;
import org.example.service.api.FlightRouteService;
import org.example.service.api.SeatService;
import org.example.service.models.modif.api.AirPlaneServiceModif;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirPlaneServiceImplModif implements AirPlaneServiceModif {

    private final AirPlaneDAO airPlaneDAO;
    private final FlightRouteService flightRouteService;
    private final SeatService seatService;


    @Override
    public AirPlane create(AirPlane airPlane) {
        Integer seatPerRow = 6;
        if (airPlane.getType() != null) {
            Integer numberSeatLowcost = airPlane.getNumberSeatLowcost();
            Integer numberSeatBuisness = airPlane.getNumberSeatBuisness();
            List<Seat> seatList = new ArrayList<>();
            for (int i = 1; i < numberSeatLowcost + 1; i++) {
                seatList.add(Seat.builder()
                        .rowSeat(numberSeatLowcost / seatPerRow + 1)
                        .place(i % seatPerRow)
                        .type("Lowcost")
                        .build());
            }
            for (int i = 1; i < numberSeatBuisness + 1; i++) {
                seatList.add(Seat.builder()
                        .rowSeat(numberSeatBuisness / seatPerRow + 1)
                        .place(i % seatPerRow)
                        .type("Buisness")
                        .build());
            }
            airPlane.setSeatList(seatList);
            return airPlaneDAO.save(airPlane);
        } else {
            throw new ErrorInvalidData("Type must not be null");
        }
    }

    @Override
    public AirPlane update(AirPlane airPlane) {
        if (airPlane.getType() != null) {
            List<FlightRoute> flightRouteList = airPlane.getFlightRouteList();
            List<Long> flightRouteIdList = flightRouteList.stream().map(FlightRoute::getId).collect(Collectors.toList());
            List<FlightRoute> flightRouteFindList = flightRouteService.readAllByIds(flightRouteIdList);
            List<Seat> seatList = airPlane.getSeatList();
            List<Long> seatIdList = seatList.stream().map(Seat::getId).collect(Collectors.toList());
            List<Seat> seatFindList = seatService.readAllByIds(seatIdList);
            airPlane.setFlightRouteList(flightRouteFindList);
            airPlane.setSeatList(seatFindList);
            return airPlaneDAO.save(airPlane);
        } else {
            throw new ErrorInvalidData("Type must not be null");
        }
    }
}
